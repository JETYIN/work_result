#include "FuncellGameSdkProxy.h"

#include <jni.h>
#include <android/log.h>
#define LOG_TAG "JNI_FuncellGameSdkProxy_SDK"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

extern "C" {
/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onInitCocos2dEnv
 * Signature: (Landroid/app/Activity;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onInitCocos2dEnv
  (JNIEnv *, jclass, jobject);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onInitSuccess
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onInitSuccess
  (JNIEnv *, jclass);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onInitFailure
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onInitFailure
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onLoginSuccess
 * Signature: (Lcom/funcell/platform/android/game/proxy/session/FuncellSession;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onLoginSuccess
  (JNIEnv *, jclass, jobject);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onLoginFailed
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onLoginFailed
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onLoginCancel
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onLoginCancel
  (JNIEnv *, jclass);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onLogout
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onLogout
  (JNIEnv *, jclass);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onSuccess
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onSuccess
  (JNIEnv *, jclass, jstring, jstring, jstring);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onFail
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onFail
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onCancel
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onCancel
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onChannelExit
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onChannelExit
  (JNIEnv *, jclass);

/*
 * Class:     com_funcell_platform_android_FuncellJniHelper
 * Method:    onGameExit
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_funcell_platform_android_FuncellJniHelper_onGameExit
  (JNIEnv *, jclass);


JNIEnv* jniEnv;
JavaVM* jvm;
jobject GlobalGameProxyObject;

IFuncellInitCallBack *mInitCallBack;
IFuncellSessionCallBack *mSessionCallBack;
IFuncellPayCallBack *mPayCallBack;

jmethodID init;
jmethodID login;
jmethodID logout;
jmethodID pay;
jmethodID funcellexit;

/********************************转换相关*****************************************/
static char* jstringTostr(JNIEnv* jniEnv, jstring jstr) {

	char* pStr = NULL;

	if (jstr != NULL) {

		jclass jstrObj = jniEnv->FindClass("java/lang/String");
		jstring encode = jniEnv->NewStringUTF("utf-8");
		jmethodID methodId = jniEnv->GetMethodID(jstrObj, "getBytes",
				"(Ljava/lang/String;)[B");
		jbyteArray byteArray = (jbyteArray) jniEnv->CallObjectMethod(jstr,
				methodId, encode);
		jsize strLen = jniEnv->GetArrayLength(byteArray);
		jbyte *jBuf = jniEnv->GetByteArrayElements(byteArray, JNI_FALSE);
		if (jBuf > 0) {
			pStr = (char*) malloc(strLen + 1);
			if (!pStr) {
				return NULL;
			}
			memcpy(pStr, jBuf, strLen);
			pStr[strLen] = 0;
		}
		jniEnv->ReleaseByteArrayElements(byteArray, jBuf, 0);
	} else {
		CCLOG("jstringTostr Method parameters is NULL!  \n");
	}

	return pStr;
}

static jstring stoJstring(JNIEnv* env, const char* pat) {
	//定义java String类 strClass
	jclass strClass = (env)->FindClass("java/lang/String");
	//获取java String类方法String(byte[],String)的构造器,用于将本地byte[]数组转换为一个新String
	jmethodID ctorID = (env)->GetMethodID(strClass, "<init>",
			"([BLjava/lang/String;)V");
	jbyteArray bytes = (env)->NewByteArray(strlen(pat)); //建立byte数组
	(env)->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*) pat); //将char* 转换为byte数组
	jstring encoding = (env)->NewStringUTF("utf-8"); // 设置String, 保存语言类型,用于byte数组转换至String时的参数
	return (jstring)(env)->NewObject(strClass, ctorID, bytes, encoding); //将byte数组转换为java String,并输出
}

static string jstringTostring(JNIEnv* env, jstring jstr) {

	if (jstr != NULL) {
		char* rtn = NULL;
		jclass clsstring = env->FindClass("java/lang/String");
		jstring strencode = env->NewStringUTF("utf-8");
		jmethodID mid = env->GetMethodID(clsstring, "getBytes",
				"(Ljava/lang/String;)[B");
		jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid,
				strencode);
		jsize alen = env->GetArrayLength(barr);
		jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
		if (alen > 0) {
			rtn = (char*) malloc(alen + 1); //new   char[alen+1];
			memcpy(rtn, ba, alen);
			rtn[alen] = 0;
		}
		env->ReleaseByteArrayElements(barr, ba, 0);
		string stemp(rtn);
		free(rtn);
		return stemp;
	} else {
		CCLOG("jstringTostring Method parameters is NULL!  \n");
		return NULL;
	}

}
/*************************************************************************/

void Java_com_funcell_platform_android_FuncellJniHelper_onInitCocos2dEnv(JNIEnv * env,jclass clazz, jobject context) {
	env->GetJavaVM(&jvm);
	if (jniEnv == NULL) {
		jniEnv = env;
	}
}

jclass GetGameProxyClass(JNIEnv* env) {
	jvm->AttachCurrentThread(&jniEnv, NULL);
	LOGI("GetGameProxyClass");
	return jniEnv->FindClass("com/funcell/platform/android/FuncellGameSdkProxyNativeStub");
}

jobject InitGameProxyObject(JNIEnv* env, jclass gpc) {
	jvm->AttachCurrentThread(&jniEnv, NULL);
	jmethodID construction_id = env->GetStaticMethodID(gpc, "getInstance","()Lcom/funcell/platform/android/FuncellGameSdkProxyNativeStub;");
	jobject gpo = jniEnv->CallStaticObjectMethod(gpc, construction_id);
	if (gpo == NULL)
		return NULL;
	else
		return env->NewGlobalRef(gpo);
}

jobject GetGameProxyObject(JNIEnv * env, jclass gpc) {
	if (GlobalGameProxyObject == NULL)
		GlobalGameProxyObject = InitGameProxyObject(env, gpc);
	return GlobalGameProxyObject;
}

void FuncellGameSdkProxy::Init(IFuncellInitCallBack *initCallBack,IFuncellSessionCallBack *sessionCallBack,IFuncellPayCallBack *payCallBack) {
	jvm->AttachCurrentThread(&jniEnv, NULL);
	mInitCallBack = initCallBack;
	mSessionCallBack = sessionCallBack;
	mPayCallBack = payCallBack;

	jclass GameProxyClass = GetGameProxyClass(jniEnv);
	jobject GameProxyObject = GetGameProxyObject(jniEnv, GameProxyClass);
	if (init == NULL) {
		init = jniEnv->GetMethodID(GameProxyClass, "init","()V");
	}
	jniEnv->CallVoidMethod(GameProxyObject, init);
}

void FuncellGameSdkProxy::Login(){
	jvm->AttachCurrentThread(&jniEnv, NULL);
	jclass GameProxyClass = GetGameProxyClass(jniEnv);
	jobject GameProxyObject = GetGameProxyObject(jniEnv, GameProxyClass);
	if (login == NULL) {
		login = jniEnv->GetMethodID(GameProxyClass, "login", "()V");
	}
	jniEnv->CallVoidMethod(GameProxyObject, login);
}

void FuncellGameSdkProxy::Logout(){
	jvm->AttachCurrentThread(&jniEnv, NULL);
	jclass GameProxyClass = GetGameProxyClass(jniEnv);
	jobject GameProxyObject = GetGameProxyObject(jniEnv, GameProxyClass);
	if (logout == NULL) {
		logout = jniEnv->GetMethodID(GameProxyClass, "logout", "()V");
	}
	jniEnv->CallVoidMethod(GameProxyObject, logout);
}

/*********************************回调信息****************************************/
void Java_com_funcell_platform_android_FuncellJniHelper_onInitSuccess(JNIEnv* env,
		jclass clazz) {
	LOGI("--------onInitSuccess--------");
	mInitCallBack->onInitSuccess();
}

void Java_com_funcell_platform_android_FuncellJniHelper_onInitFailure(JNIEnv* env,
		jclass clazz, jstring msg) {
	LOGI("--------onInitFailure--------");
	char *info = jstringTostr(jniEnv, msg);
	mInitCallBack->onInitFailure(info);
}

void Java_com_funcell_platform_android_FuncellJniHelper_onLoginSuccess
  (JNIEnv *env, jclass clazz, jobject msg){
	LOGI("--------onLoginSuccess--------");

}

void Java_com_funcell_platform_android_FuncellJniHelper_onLoginFailed(
		JNIEnv *env, jclass clazz, jstring msg){
	LOGI("--------onLoginFailed--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onLoginCancel(JNIEnv *env,
		jclass clazz){
	LOGI("--------onLoginCancel--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onLogout(JNIEnv *env,
		jclass clazz) {
	LOGI("--------onLogout--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onSuccess(JNIEnv *env,
		jclass clazz, jstring cporder, jstring sdkorder, jstring ext) {
	LOGI("--------onSuccess--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onFail(JNIEnv *env,
		jclass clazz, jstring msg) {
	LOGI("--------onFail--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onCancel(JNIEnv *env,
		jclass clazz, jstring msg) {
	LOGI("--------onCancel--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onChannelExit(
		JNIEnv *env, jclass clazz) {
	LOGI("--------onChannelExit--------");
}

void Java_com_funcell_platform_android_FuncellJniHelper_onGameExit(JNIEnv *env,
		jclass clazz) {
	LOGI("--------onGameExit--------");
}
/******************************************************************/

}
