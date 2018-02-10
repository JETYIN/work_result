/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haowan.funcell.common.sdk.api.volley.toolbox;

import java.io.File;  
import java.io.IOException;  
import java.io.InputStream;  
import java.security.KeyManagementException;  
import java.security.KeyStore;  
import java.security.KeyStoreException;  
import java.security.NoSuchAlgorithmException;  
import java.security.UnrecoverableKeyException;  
import java.security.cert.Certificate;  
import java.security.cert.CertificateException;  
import java.security.cert.CertificateFactory;  

import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSocketFactory;  
import javax.net.ssl.TrustManagerFactory;  

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;  

import com.haowan.funcell.common.sdk.api.volley.Network;
import com.haowan.funcell.common.sdk.api.volley.RequestQueue;

import android.content.Context;  
import android.content.pm.PackageInfo;  
import android.content.pm.PackageManager.NameNotFoundException;  
import android.net.http.AndroidHttpClient;
import android.os.Build;  
import android.util.Log;
  
public class Volley {

    /** Default on-disk cache directory. */
    private static final String DEFAULT_CACHE_DIR = "volley";

    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     * You may set a maximum size of the disk cache in bytes.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @param stack An {@link HttpStack} to use for the network, or null for default.
     * @param maxDiskCacheBytes the maximum size of the disk cache, in bytes. Use -1 for default size.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context, HttpStack stack, int maxDiskCacheBytes,boolean signedCertificate, int certResourceID) {
        File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);

        String userAgent = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            userAgent = packageName + "/" + info.versionCode;
        } catch (NameNotFoundException e) {
        }

        if (stack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
            	if(signedCertificate){
            		stack = new HurlStack(null, buildSSLSocketFactory(context));
            	}else {
            		stack = new HurlStack();
				}
            } else {
                // Prior to Gingerbread, HttpUrlConnection was unreliable.
                // See: http://android-developers.blogspot.com/2011/09/androids-http-clients.html
            	if(signedCertificate){
            		stack = new HttpClientStack(getHttpClient(context));
            	}else {
            		stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
				}
            }
        }

        Network network = new BasicNetwork(stack);
        
        RequestQueue queue;
        if (maxDiskCacheBytes <= -1)
        {
        	// No maximum size specified
        	queue = new RequestQueue(new DiskBasedCache(cacheDir), network);
        }
        else
        {
        	// Disk cache size specified
        	queue = new RequestQueue(new DiskBasedCache(cacheDir, maxDiskCacheBytes), network);
        }

        queue.start();

        return queue;
    }
    
    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     * You may set a maximum size of the disk cache in bytes.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @param maxDiskCacheBytes the maximum size of the disk cache, in bytes. Use -1 for default size.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context, int maxDiskCacheBytes) {
        return newRequestQueue(context, null, maxDiskCacheBytes,false,-1);
    }
    
    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @param stack An {@link HttpStack} to use for the network, or null for default.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context, HttpStack stack)
    {
    	return newRequestQueue(context, stack, -1,false,-1);
    }
    
    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
    
    private static SSLSocketFactory buildSSLSocketFactory(Context context) {
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			sslContext.init(null, null, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return sslContext.getSocketFactory();
	}
    
	private static SSLSocketFactory buildSSLSocketFactory(Context context,int certResourceID) {
		KeyStore keyStore = null;
		try {
			keyStore = buildKeyStore(context, certResourceID);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory tmf = null;
		try {
			tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
			tmf.init(keyStore);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}

		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			sslContext.init(null, tmf.getTrustManagers(), null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		return sslContext.getSocketFactory();

	}

	public static synchronized HttpClient getHttpClient(Context context) {
		KeyStore keyStore = null;
		try {
			keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		org.apache.http.conn.ssl.SSLSocketFactory sslSocketFactory = null;
		try {
			sslSocketFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		}

		HttpParams params = new BasicHttpParams();

		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		schemeRegistry.register(new Scheme("https", sslSocketFactory, 443));

		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(
				params, schemeRegistry);

		return new DefaultHttpClient(cm, params);
	}
	
	public static synchronized HttpClient getHttpClient(Context context, int certResourceID) {
		KeyStore keyStore = null;
		try {
			keyStore = buildKeyStore(context, certResourceID);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (keyStore != null) {
		}
		org.apache.http.conn.ssl.SSLSocketFactory sslSocketFactory = null;
		try {
			sslSocketFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		}

		HttpParams params = new BasicHttpParams();

		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		schemeRegistry.register(new Scheme("https", sslSocketFactory, 443));

		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(
				params, schemeRegistry);

		return new DefaultHttpClient(cm, params);
	}

	private static KeyStore buildKeyStore(Context context, int certResourceID)
			throws KeyStoreException, CertificateException,
			NoSuchAlgorithmException, IOException {
		String keyStoreType = KeyStore.getDefaultType();
		KeyStore keyStore = KeyStore.getInstance(keyStoreType);
		keyStore.load(null, null);

		Certificate cert = readCert(context, certResourceID);
		keyStore.setCertificateEntry("ca", cert);

		return keyStore;
	}

	private static Certificate readCert(Context context, int certResourceID) {
		InputStream inputStream = context.getResources().openRawResource(
				certResourceID);
		Certificate ca = null;

		CertificateFactory cf = null;
		try {
			cf = CertificateFactory.getInstance("X.509");
			ca = cf.generateCertificate(inputStream);

		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return ca;
	}
}

