package com.funcell.platform.android.permissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class FuncellPermissionsManager {
	private final static String TAG = "FuncellPermissionsManager";

	private final Object mObject;
	private final FuncellPermissionsCallbacks mPermissionsCallbacks;
	private final String mRationale4ReqPer;
	private final String mRationale4NeverAskAgain;

	private final int mPositiveBtn4ReqPer;
	private final int mNegativeBtn4ReqPer;
	private final int mPositiveBtn4NeverAskAgain;
	private final int mNegativeBtn4NeverAskAgain;

	private final int mRequestCode;
	private static FuncellPermissionsManager instance;

	/**
	 * ���췽��,����һ�����õ�FuncellPermissionsManager
	 *
	 * @param object
	 *            ��������Context,�п�����Activity,Fragment,android.app.Fragment
	 * @param permissionsCallbacks
	 *            �����û��ṩȨ�޵��¼�
	 * @param rationale4ReqPer
	 *            ѯ���Ƿ�ǰ������Ȩ�޵���ʾ��
	 * @param rationale4NeverAskAgain
	 *            ѯ����֮ǰѡ����"����ѯ��"֮���Ƿ�ѡ��ȥ�������޸�Ȩ�޵���ʾ��
	 * @param positiveBtn4ReqPer
	 *            ѯ���Ƿ�ǰ������Ȩ��ʱPositive Button�ϵ�String��Res id
	 * @param negativeBtn4ReqPer
	 *            ѯ���Ƿ�ǰ������Ȩ��ʱNegative Button�ϵ�String��Res id
	 * @param positiveBtn4NeverAskAgain
	 *            ѯ����֮ǰѡ����"����ѯ��"֮���Ƿ�ѡ��ȥ�������޸�Ȩ��ʱ Positive Button�ϵ�String��Res id
	 * @param negativeBtn4NeverAskAgain
	 *            ѯ����֮ǰѡ����"����ѯ��"֮���Ƿ�ѡ��ȥ�������޸�Ȩ��ʱ Negative Button�ϵ�String��Res id
	 * @param requestCode
	 *            ������
	 */
	FuncellPermissionsManager(Object object, FuncellPermissionsCallbacks permissionsCallbacks, String rationale4ReqPer,
			String rationale4NeverAskAgain, @StringRes int positiveBtn4ReqPer, @StringRes int negativeBtn4ReqPer,
			@StringRes int positiveBtn4NeverAskAgain, @StringRes int negativeBtn4NeverAskAgain, int requestCode) {
		this.mObject = object;
		this.mPermissionsCallbacks = permissionsCallbacks;
		this.mRationale4ReqPer = rationale4ReqPer;
		this.mRationale4NeverAskAgain = rationale4NeverAskAgain;
		this.mPositiveBtn4ReqPer = positiveBtn4ReqPer;
		this.mNegativeBtn4ReqPer = negativeBtn4ReqPer;
		this.mPositiveBtn4NeverAskAgain = positiveBtn4NeverAskAgain;
		this.mNegativeBtn4NeverAskAgain = negativeBtn4NeverAskAgain;
		this.mRequestCode = requestCode;
	}

	/**
	 * ��ʼ��������Ȩ����صĹ���
	 *
	 * @param perms
	 *            Ҫ�����Ȩ�޵��б�
	 */
	public void requestPermissions(String... perms) {
		if (mObject == null || TextUtils.isEmpty(mRationale4ReqPer) || TextUtils.isEmpty(mRationale4NeverAskAgain)
				|| mRequestCode == -1) {
			throw new IllegalArgumentException("You should init these arguments .");
		}
		requestPermissions(mObject, mRationale4ReqPer,
				mPositiveBtn4ReqPer == -1 ? android.R.string.ok : mPositiveBtn4ReqPer,
				mNegativeBtn4ReqPer == -1 ? android.R.string.cancel : mNegativeBtn4ReqPer, mRequestCode, perms);
	}

	/**
	 * ��鵱ǰAPP�Ƿ�����Ȩ�޻�����������Ȩ��
	 *
	 * @param context
	 *            ��������context
	 * @param perms
	 *            �����Ȩ���б�
	 * @return ���Ϊtrue, ��ʾ����Ҫ����Ȩ��, ���Ϊfalse, ��ʾ��Ҫ����Ȩ��
	 */
	public static boolean hasPermissions(Context context, String... perms) {
		// Always return true for SDK < M, let the system deal with the
		// permissions
		if (Build.VERSION.SDK_INT < 23) {
			Log.w(TAG, "hasPermissions: API version < M, returning true by default");
			return true;
		}

		for (String perm : perms) {
			boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED);
			if (!hasPerm) {
				Log.e(TAG, "----has not permission,return false");
				return false;
			}
		}
		return true;
	}

	/**
	 * ��ʼ��������Ȩ����صĹ���
	 *
	 * @param object
	 *            ��������Context,�п�����Activity,Fragment,android.app.Fragment
	 * @param rationale
	 *            ѯ���Ƿ�ǰ������Ȩ�޵���ʾ��
	 * @param positiveButton
	 *            ѯ���Ƿ�ǰ������Ȩ��ʱPositive Button�ϵ�String��Res id
	 * @param negativeButton
	 *            ѯ���Ƿ�ǰ������Ȩ��ʱNegative Button�ϵ�String��Res id
	 * @param requestCode
	 *            ������
	 * @param perms
	 *            �����Ȩ�޵��б�
	 */
	private void requestPermissions(final Object object, String rationale, @StringRes int positiveButton,
			@StringRes int negativeButton, final int requestCode, final String... perms) {
		// ���object�Ϸ���
		checkCallingObjectSuitability(object);

		if (!hasPermissions(getActivity(object), perms)) {// ����23

			boolean shouldShowRationale = false;
			for (String perm : perms) {
				shouldShowRationale = shouldShowRationale || shouldShowRequestPermissionRationale(object, perm);
			}

			if (shouldShowRationale) {
				Activity activity = getActivity(object);
				if (null == activity) {
					return;
				}

				AlertDialog dialog = new AlertDialog.Builder(activity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
						.setMessage(rationale).setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Log.e(TAG, "****PositiveButton click");
								executePermissionsRequest(object, perms, requestCode);
							}
						}).setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// act as if the permissions were denied
								Log.e(TAG, "----Negative click");
								checkDeniedPermissionsNeverAskAgain(object, mRationale4NeverAskAgain,
										mPositiveBtn4NeverAskAgain == -1 ? android.R.string.yes
												: mPositiveBtn4NeverAskAgain,
										mNegativeBtn4NeverAskAgain == -1 ? android.R.string.cancel
												: mNegativeBtn4NeverAskAgain,
										Arrays.asList(perms));
								if (mPermissionsCallbacks != null) {
									mPermissionsCallbacks.onPermissionsDenied(requestCode, Arrays.asList(perms));
								}

							}
						}).create();
				// dialog.show();// notice
			} else {
				Log.e(TAG, "****executePermissionsRequest");
				executePermissionsRequest(object, perms, requestCode);
			}
			return;
		}

		if (mPermissionsCallbacks != null) {
			mPermissionsCallbacks.onPermissionsGranted(requestCode, Arrays.asList(perms));
		}
	}

	private void checkCallingObjectSuitability(Object object) {
		// ȷ��object��һ��Activity����Fragment
		boolean isActivity = object instanceof Activity;
		boolean isSupportFragment = object instanceof Fragment;
		boolean isAppFragment = object instanceof android.app.Fragment;
		boolean isMinSdkM = Build.VERSION.SDK_INT >= 23;

		if (!(isSupportFragment || isActivity || (isAppFragment && isMinSdkM))) {
			if (isAppFragment) {
				throw new IllegalArgumentException(
						"Target SDK needs to be greater than 23 if caller is android.app.Fragment");
			} else {
				throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
			}
		}
	}

	@TargetApi(23)
	private boolean shouldShowRequestPermissionRationale(Object object, String perm) {
		if (object instanceof Activity) {
			return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
		} else if (object instanceof Fragment) {
			return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
		} else if (object instanceof android.app.Fragment) {
			// return ((android.app.Fragment)
			// object).shouldShowRequestPermissionRationale(perm);
			// //23�вŻ���shouldShowRequestPermissionRationale
			return false;
		} else {
			return false;
		}
	}

	@TargetApi(23)
	private void executePermissionsRequest(Object object, String[] perms, int requestCode) {
		checkCallingObjectSuitability(object);

		if (object instanceof Activity) {
			ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
		} else if (object instanceof Fragment) {
			((Fragment) object).requestPermissions(perms, requestCode);
		} else if (object instanceof android.app.Fragment) {
			// ((android.app.Fragment) object).requestPermissions(perms,
			// requestCode);
		}
	}

	@TargetApi(11)
	private Activity getActivity(Object object) {
		if (object instanceof Activity) {
			return ((Activity) object);
		} else if (object instanceof Fragment) {
			return ((Fragment) object).getActivity();
		} else if (object instanceof android.app.Fragment) {
			return ((android.app.Fragment) object).getActivity();
		} else {
			return null;
		}
	}

	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults, Object object) {

		checkCallingObjectSuitability(object);

		ArrayList<String> granted = new ArrayList<>();
		ArrayList<String> denied = new ArrayList<>();
		for (int i = 0; i < permissions.length; i++) {
			String perm = permissions[i];
			if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
				granted.add(perm);
			} else {
				denied.add(perm);
			}
		}

		// Report granted permissions, if any.
		if (!granted.isEmpty()) {
			// Notify callbacks
			if (mPermissionsCallbacks != null) {
				mPermissionsCallbacks.onPermissionsGranted(requestCode, granted);
			}
		}

		// Report denied permissions, if any.
		if (!denied.isEmpty()) {
			checkDeniedPermissionsNeverAskAgain(object, mRationale4NeverAskAgain,
					mPositiveBtn4NeverAskAgain == -1 ? android.R.string.yes : mPositiveBtn4NeverAskAgain,
					mNegativeBtn4NeverAskAgain == -1 ? android.R.string.cancel : mNegativeBtn4NeverAskAgain, denied);
			if (mPermissionsCallbacks != null) {
				mPermissionsCallbacks.onPermissionsDenied(requestCode, denied);
			}
		}
	}

	@TargetApi(11)
	private void startAppSettingsScreen(Object object, Intent intent) {
		if (object instanceof Activity) {
			((Activity) object).startActivityForResult(intent, mRequestCode);
		} else if (object instanceof Fragment) {
			((Fragment) object).startActivityForResult(intent, mRequestCode);
		} else if (object instanceof android.app.Fragment) {
			((android.app.Fragment) object).startActivityForResult(intent, mRequestCode);
		}
	}

	private boolean checkDeniedPermissionsNeverAskAgain(final Object object, String rationale,
			@StringRes int positiveButton, @StringRes int negativeButton, List<String> deniedPerms) {
		return checkDeniedPermissionsNeverAskAgain(object, rationale, positiveButton, negativeButton, null,
				deniedPerms);
	}

	/**
	 * ��鱻�ܾ��ṩ��Ȩ���Ƿ�ѡ���˲���ѯ��
	 */
	private boolean checkDeniedPermissionsNeverAskAgain(final Object object, String rationale,
			@StringRes int positiveButton, @StringRes int negativeButton,
			@Nullable DialogInterface.OnClickListener negativeButtonOnClickListener, List<String> deniedPerms) {
		boolean shouldShowRationale;
		for (String perm : deniedPerms) {
			shouldShowRationale = shouldShowRequestPermissionRationale(object, perm);
			if (!shouldShowRationale) {
				final Activity activity = getActivity(object);
				if (null == activity) {
					return true;
				}

				AlertDialog dialog = new AlertDialog.Builder(activity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
						.setMessage(rationale).setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
								Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
								intent.setData(uri);
								startAppSettingsScreen(object, intent);
							}
						}).setNegativeButton(negativeButton, negativeButtonOnClickListener).create();
				dialog.show();

				return true;
			}
		}

		return false;
	}

	/*
	 * public static final class Builder { private Context mContext; private
	 * FuncellPermissionsCallbacks mFuncellPermissionsCallbacks; private String
	 * mRationale4ReqPer; private String mRationale4NeverAskAgain; private int
	 * mPositiveBtn4ReqPer = -1; private int mNegativeBtn4ReqPer = -1; private
	 * int mPositiveBtn4NeverAskAgain = -1; private int
	 * mNegativeBtn4NeverAskAgain = -1; private int mRequestCode = -1;
	 * 
	 * public Builder(Context context) { this.mContext = context; }
	 * 
	 * public Builder onFuncellPermissionsCallbacks(FuncellPermissionsCallbacks
	 * funcellPermissionsCallbacks){ this.mFuncellPermissionsCallbacks =
	 * funcellPermissionsCallbacks; return this; }
	 * 
	 * public Builder rationale4ReqPer(String rationale4ReqPer) {
	 * this.mRationale4ReqPer = rationale4ReqPer; return this; }
	 * 
	 * public Builder positiveBtn4ReqPer(int positiveBtn4ReqPer) {
	 * this.mPositiveBtn4ReqPer = positiveBtn4ReqPer; return this; }
	 * 
	 * public Builder positiveBtn4NeverAskAgain(int positiveBtn4NeverAskAgain) {
	 * this.mPositiveBtn4NeverAskAgain = positiveBtn4NeverAskAgain; return this;
	 * }
	 * 
	 * public Builder negativeBtn4ReqPer(int negativeBtn4ReqPer) {
	 * this.mNegativeBtn4ReqPer = negativeBtn4ReqPer; return this; }
	 * 
	 * public Builder negativeBtn4NeverAskAgain(int negativeBtn4NeverAskAgain) {
	 * this.mNegativeBtn4NeverAskAgain = negativeBtn4NeverAskAgain; return this;
	 * }
	 * 
	 * public Builder rationale4NeverAskAgain(String rationale4NeverAskAgain) {
	 * this.mRationale4NeverAskAgain = rationale4NeverAskAgain; return this; }
	 * 
	 * public Builder requestCode(int requestCode) { this.mRequestCode =
	 * requestCode; return this; }
	 * 
	 * public FuncellPermissionsManager build() { return new
	 * FuncellPermissionsManager( mContext, mFuncellPermissionsCallbacks,
	 * mRationale4ReqPer, mRationale4NeverAskAgain, mPositiveBtn4ReqPer,
	 * mNegativeBtn4ReqPer, mPositiveBtn4NeverAskAgain,
	 * mNegativeBtn4NeverAskAgain, mRequestCode ); } }
	 */
}
