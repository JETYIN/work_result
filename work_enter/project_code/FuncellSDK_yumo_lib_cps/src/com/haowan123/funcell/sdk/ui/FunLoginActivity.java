package com.haowan123.funcell.sdk.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.haowan123.funcell.sdk.apiinterface.FunCellPlatformSdkApi;
import com.haowan123.funcell.sdk.apiinterface.LoginCallBack;
import com.haowan123.funcell.sdk.ui.FunQuickLoginDialog.IQuickLoginClick;
import com.haowan123.funcell.sdk.util.FunErrorCode;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils.AtsLogTaskInfo;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils.LogTaskInfo;
import com.reyun.sdk.TrackingIO;
import com.haowan123.funcell.sdk.util.HWConstant;
import com.haowan123.funcell.sdk.util.HWFileUtils;
import com.haowan123.funcell.sdk.util.HWHttpResponse;
import com.haowan123.funcell.sdk.util.HWPreferences;
import com.haowan123.funcell.sdk.util.HWUtils;
import com.haowan123.funcell.sdk.util.JsonObjectCoder;
import com.haowan123.funcell.sdk.util.RUtils;

public class FunLoginActivity extends Activity implements OnClickListener {
	private static final String TAG = "FunLoginActivity";
	private ListView listView;

	private TextView loginRerms;
	private ImageButton backGameBtn;
	private Button loginBtn;
	private TextView loginAccountTv;
	private TextView loginPwdTv;
	private TextView findPwdTv, registTv, quickIntoGameTv;

	private String userAccount = null;
	private String account = null;
	private String pwd = null;
	private String rePwd = null;
	private String cpId = null;
	private String hw_refresh_token = null;
	private String hw_platform = null;
	private String fid = null;
	private String error;

	private LoginAsyncTask loginAsyncTask = null;
	private ProgressBar loginProgressBar = null;
	private RelativeLayout loginRelativeLayout;
	private LinearLayout loginAccountLinearLayout;

	private static final String QUICK_LOGIN_DEFAULT_PWD = "**********";

	private boolean isQuickLogin = false;
	private int loginMode = 0;

	private static final int LOGIN_MODE_DEFAULT = 0;
	private static final int LOGIN_MODE_GUEST = 1;
	private static final int LOGIN_MODE_QUICK = 2;

	private static final int INTERVAL_TIME = 2000;
	public static boolean isAuth;

	public static LoginCallBack mLoginCallBack;

	private boolean isWindowMode = true;
	private FunQuickLoginDialog quickDialog;
	private boolean isShowQuickDialog;
	private Map<String, String> userNameMap = new HashMap<String, String>();

	private Map<String, List<String>> infoMap = new HashMap<>();// 读取的快速登录数据
	private List<String> userList;

	public static void setOnLoginCallBack(LoginCallBack loginCallBack) {
		mLoginCallBack = loginCallBack;
	}

	private void initData() {

		Intent intent = getIntent();
		if (null == intent) {
			return;
		}
		error = intent.getStringExtra("error");
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/** 根据是否是快速登录进行ui布局加载,切换账号应当吊起登录框 **/

		HWUtils.logError(TAG, "****加载快速登录ui布局");
		if (isQuicklyLogin() && !FunCellPlatformSdkApi.getInstance().getIsSwitchUser()) {

			initQuickLyData();

		} else {
			HWUtils.logError(TAG, "****加载普通登录ui布局");
			setContentView(RUtils.layout(FunLoginActivity.this, "fun_login"));

			HWUtils.setWindowDisplayMode(FunLoginActivity.this, 280, 0.8f, 0.9f);
			initViews();
			initData();
			initEvents();

			infoMap = HWFileUtils.readUserInfo();// 包含所有登录过的用户信息

			userList = HWFileUtils.getKey();// 文件中所有用户账号

			adapter = new DropdownAdapter(this, userList);
			listView = new ListView(this);
			TextView textView = new TextView(this);
			listView.setEmptyView(textView);
			listView.setAdapter(adapter);

			ColorDrawable colorDrawable = new ColorDrawable(Color.GRAY);
			listView.setDivider(colorDrawable);
			listView.setDividerHeight(1);

			// textView
			//

			selectUserImageBtn = (ImageButton) findViewById(RUtils.id(FunLoginActivity.this, "imgbtn"));
			selectUserImageBtn.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// 构造方法写在onCreate方法体中会因为布局没有加载完毕而得不到宽高。
					int len = 0;
					if (3 > userList.size()) {
						len = userList.size();
					} else {
						len = 3;
					}
					if (null == pop) {
						// 创建一个在输入框下方的popup
						pop = new PopupWindow(listView, loginAccountLinearLayout.getWidth(),
								len * loginAccountLinearLayout.getHeight());
						pop.showAsDropDown(loginAccountLinearLayout);
						selectUserImageBtn
								.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_up"));
					} else {
						if (pop.isShowing()) {
							pop.dismiss();
							selectUserImageBtn
									.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_button"));
						} else {
							pop.setHeight(len * loginAccountLinearLayout.getHeight());
							pop.setWidth(loginAccountLinearLayout.getWidth());
							pop.showAsDropDown(loginAccountLinearLayout);
							selectUserImageBtn
									.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_up"));
						}
					}
				}
			});
			// 自动登录失败，需要弹出登录框，并提示上次登录失败原因
			if (!TextUtils.isEmpty(error)) {
				showErrorMsg();
			}
		}

	}

	private void showErrorMsg() {
		if (loginAccountTv != null) {

			loginAccountTv.setError(
					getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_fail")));
			loginAccountTv.requestFocus();
		}
	}

	private void initQuickLyData() {

		// 读取文件中保存信息
		// 只读取最近登录成功账号-此处只包含有一个账号信息
		isQuickLogin = true;
		isShowQuickDialog = true;
		quickDialog = new FunQuickLoginDialog(FunLoginActivity.this, userAccount);
		quickDialog.show();
		final Handler handler = new Handler();
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (null == FunLoginActivity.this || FunLoginActivity.this.isFinishing()
						|| FunLoginActivity.this.isDestroyed()) {
					return;
				}
				quickDialog.dismiss();
				quickDialog.unrigisterListDialogClick();
				// 显示3s窗体，3s结束后开始快速登录
				loginAsyncTask = new LoginAsyncTask();
				loginAsyncTask.execute(isQuickLogin);
			}
		};

		quickDialog.rigisterListDialogClick(new IQuickLoginClick() {

			public void onSwitchClick() {
				// TODO Auto-generated method stub
				if (FunSdkUiActivity.mLogoutCallBack != null) {

					// FunSdkUiActivity.mLogoutCallBack.logout();
					quickDialog.dismiss();
					// 点击切换账号--移除
					handler.removeCallbacks(runnable);
					finish();
					// 内部切换账号，调用登录
					Intent intent = new Intent(FunLoginActivity.this, FunLoginActivity.class);
					FunLoginActivity.this.startActivity(intent);
				}
			}
		});

		handler.postDelayed(runnable, 3500L);// 执行延时任务等待框显示3s，等待框消失后进行登录任务

	}

	private void initViews() {
		// listView = (ListView) findViewById(R.id.fun_login_about_action_list);

		loginRelativeLayout = (RelativeLayout) findViewById(
				RUtils.id(FunLoginActivity.this, "fun_login_relativelayout"));

		// 导航--返回到登录界面的按钮
		backGameBtn = (ImageButton) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_back_game_btn"));

		// 账号
		loginAccountLinearLayout = (LinearLayout) findViewById(
				RUtils.id(FunLoginActivity.this, "fun_login_account_linearLayout"));
		loginAccountTv = (TextView) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_account_et"));

		// 密码
		loginPwdTv = (TextView) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_pwd_et"));

		// 登录按钮
		loginBtn = (Button) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_btn"));

		findPwdTv = (TextView) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_find_pwd"));
		registTv = (TextView) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_regist"));
		quickIntoGameTv = (TextView) findViewById(RUtils.id(FunLoginActivity.this, "fun_login_quick_into_game"));
	}

	//
	private boolean isQuicklyLogin() {
		infoMap = HWFileUtils.readQuickAccount();

		if (null == infoMap) {

			return false;
		}

		for (String key : infoMap.keySet()) {

			userAccount = key;
			hw_refresh_token = infoMap.get(key).get(0);

		}

		if (null != hw_refresh_token && 0 < hw_refresh_token.trim().length()) {
			HWUtils.logError(TAG, "****本地保存有token，当前是快速登录，返回true");
			return true;
		}

		return false;
	}

	private void initEvents() {
		// getListView();

		// access_token
		// refresh_token
		backGameBtn.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
		findPwdTv.setOnClickListener(this);
		registTv.setOnClickListener(this);
		quickIntoGameTv.setOnClickListener(this);

		// 切换账号触发时--切换账号将会加载普通登录ui，将读取保存的账号信息，如果不为空将用以填充登录框
		infoMap = HWFileUtils.readQuickAccount();

		if (null == infoMap) {

			return;
		}

		for (String key : infoMap.keySet()) {

			account = key;
			hw_refresh_token = infoMap.get(key).get(0);

		}
		HWUtils.logError(TAG, hw_refresh_token + "   ,   " + userAccount);
		if (null != hw_refresh_token && 0 < hw_refresh_token.trim().length()) {
			loginAccountTv.setText(userAccount);
			userAccount = account;
			loginPwdTv.setText(QUICK_LOGIN_DEFAULT_PWD);// 已登录过一次，快速登录时设置的默认密码******
			quickIntoGameTv.setVisibility(View.INVISIBLE);
			isQuickLogin = true;
		}

		loginAccountTv.addTextChangedListener(loginAccountTextWatcher);
		loginPwdTv.addTextChangedListener(loginPwdTextWatcher);

	}

	private void getListView() {
		// 生成动态数组，加入数据
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		final boolean isAllowGuestLogin = FunCellPlatformSdkApi.getInstance().isAllowGuestLogin();
		if (isAllowGuestLogin) {
			HashMap<String, Object> guestMap = new HashMap<String, Object>();
			guestMap.put("ItemTitle",
					getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_guest_title")));
			listItem.add(guestMap);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemTitle",
				getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_regist_title")));
		listItem.add(map);
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("ItemTitle",
				getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_forget_title")));
		listItem.add(map1);

		// 生成适配器的Item和动态数组对应的元素
		SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, // 数据源
				RUtils.layout(FunLoginActivity.this, "fun_login_about_action_list_item"), // ListItem的XML实现
				// 动态数组与TextView对应的子项
				new String[] { "ItemTitle" },
				// TextView ID
				new int[] { RUtils.id(FunLoginActivity.this, "fun_login_about_action_list_item_text_title") });

		listView.setAdapter(listItemAdapter);

		setListViewHeightBasedOnChildren(listView);

		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
				case 0:
					if (isAllowGuestLogin) {
						// TODO 游客登录功能
					} else {
						startActivityForResult(new Intent(FunLoginActivity.this, FunRegistActivity.class),
								HWConstant.REGIST_REQUEST_CODE);
					}
					finish();
					break;
				case 1:
					if (isAllowGuestLogin) {
						startActivityForResult(new Intent(FunLoginActivity.this, FunRegistActivity.class),
								HWConstant.REGIST_REQUEST_CODE);
					} else {
						Intent intent = new Intent(FunLoginActivity.this, FunSdkUiActivity.class);
						intent.putExtra("fun_action", "findpwd");
						startActivity(intent);

					}
					finish();
					break;
				case 2:
					if (isAllowGuestLogin) {
						Intent findPwdIntent = new Intent(FunLoginActivity.this, FunSdkUiActivity.class);
						findPwdIntent.putExtra("fun_action", "findpwd");
						startActivity(findPwdIntent);
					}
					finish();
					break;

				default:
					break;
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == HWConstant.REGIST_REQUEST_CODE) {
			if (resultCode == HWConstant.RESULT_CODE_REGIST_SUCCESS) {
				HWUtils.logError(TAG, "hwsdk: login success...");

				String hwAccessToken = data.getStringExtra("hw_access_token");
				String mFid = data.getStringExtra("fid");
				String adult = data.getStringExtra("adult");
				String guest = data.getStringExtra("guest");
				// 登录成功回调
				if (null != mLoginCallBack) {

					mLoginCallBack.loginSuccess(hwAccessToken, mFid, guest, adult);
				}
				// need real name authentication
				adult(adult);

				finish();
			}
		}
	}

	private void adult(String adult) {
		if ("2".equals(adult)) {
			HWUtils.logError(TAG, "account need real name authentication. ");
			Intent adultIntent = new Intent(FunLoginActivity.this, FunSdkUiActivity.class);
			adultIntent.putExtra("fun_action", "adult");
			startActivity(adultIntent);
		}
	}

	public void onClick(View v) {
		int id = v.getId();
		if (id == RUtils.id(FunLoginActivity.this, "fun_login_back_game_btn")) {
			if (HWUtils.isFastDoubleClick(1000)) {
				return;
			}
			if (mLoginCallBack != null) {

				mLoginCallBack.loginFail(FunErrorCode.FUN_ERROR_CODE_LOGIN_CANCEL, "cancel login");
			}
			finish();

		} // 点击登录按钮
		else if (id == RUtils.id(FunLoginActivity.this, "fun_login_btn")) {
			if (HWUtils.isFastDoubleClick(1000)) {
				return;
			}
			if (null == loginAccountTv.getText() || 0 == loginAccountTv.getText().length()) {

				loginAccountTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_account_isempty")));
			}
			if (null == loginPwdTv.getText() || 0 == loginPwdTv.getText().length()) {

				loginPwdTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_pwd_isempty")));
			}
			if (!isAccountLengthLegal(loginAccountTv.getText())) {
				return;
			}
			if (!isPwdLengthLegal(loginPwdTv.getText())) {
				return;
			}
			loginAsyncTask = new LoginAsyncTask();
			loginAsyncTask.execute(isQuickLogin);
		} else if (id == RUtils.id(FunLoginActivity.this, "fun_login_find_pwd")) {
			if (HWUtils.isFastDoubleClick(1000)) {
				return;
			}
			Intent findPwdIntent = new Intent(FunLoginActivity.this, FunSdkUiActivity.class);
			findPwdIntent.putExtra("fun_action", "findpwd");
			startActivity(findPwdIntent);
		} else if (id == RUtils.id(FunLoginActivity.this, "fun_login_regist")) {
			if (HWUtils.isFastDoubleClick(1000)) {
				return;
			}
			startActivityForResult(new Intent(FunLoginActivity.this, FunRegistActivity.class),
					HWConstant.REGIST_REQUEST_CODE);
		} else if (id == RUtils.id(FunLoginActivity.this, "fun_login_quick_into_game")) {// 游客模式
			if (HWUtils.isFastDoubleClick(1000)) {
				return;
			}
			loginAsyncTask = new LoginAsyncTask();
			loginAsyncTask.execute(LOGIN_MODE_GUEST);
			// 切换账号
		} else if (id == RUtils.id(FunLoginActivity.this, "switch_tv")) {
		}

	}

	/**
	 * TextWatcher：接口，继承它要实现其三个方法，分别为Text改变之前、改变的过程中、改变之后各自发生的动作
	 */
	private TextWatcher loginAccountTextWatcher = new TextWatcher() {

		private CharSequence charSequence;
		private int editStart;
		private int editEnd;

		public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
			charSequence = s;
		}

		public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

		}

		public void afterTextChanged(Editable s) {

			// // 输入的时候，只有一个光标，那么这两个值应该是相等的。。。
			// editStart = registAccountTv.getSelectionStart();
			// editEnd = registAccountTv.getSelectionEnd();
			// int len = charSequence.length();

			// 限定EditText只能输入5-20个
			HWUtils.logError(TAG, s.toString());
			if (!isAccountLengthLegal(charSequence)) {
				loginAccountTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_hint_account_input_rule")));
			}

			// // 限定EditText只能输入20个数字
			// if (len > 20) {
			// // 默认光标在最前端，所以当输入第21个数字的时候，删掉（光标位置从21-1到21）的数字，这样就无法输入超过20个以后的数字
			// // s.delete(editStart - 1, editEnd);
			// registAccountTv.setError("请输入5-20位数字|字母|下划线");
			// } else if (len < 5) {
			// registAccountTv.setError("请输入5-20位数字|字母|下划线");
			// }
		}
	};

	private TextWatcher loginPwdTextWatcher = new TextWatcher() {

		private CharSequence charSequence;

		public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
			charSequence = s;
		}

		public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

		}

		public void afterTextChanged(Editable s) {
			HWUtils.logError(TAG, s.toString());
			isQuickLogin = false;// 密码框中输入了字符我们默认不使用快速登录，而使用账号密码登录的方式
			// 限定EditText只能输入6-20个
			if (!isPwdLengthLegal(charSequence)) {
				loginPwdTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_hint_pwd_input_rule")));
			}
		}
	};

	/**
	 * 验证密码长度是否合法
	 * 
	 * @param charSequence
	 * @return true|false
	 */
	private boolean isPwdLengthLegal(CharSequence charSequence) {
		if (null == charSequence) {
			return false;
		}

		int len = charSequence.length();

		// 限定EditText只能输入6-20个时,返回true
		if (len < 6 || len > 20) {
			return false;
		}

		return true;
	}

	/**
	 * 验证用户名长度是否合法
	 * 
	 * @param charSequence
	 * @return true|false
	 */
	private boolean isAccountLengthLegal(CharSequence charSequence) {
		if (null == charSequence) {
			return false;
		}

		int len = charSequence.length();

		// 限定EditText只能输入5-20个时,返回true
		if (len < 4 || len > 20) {
			return false;
		}

		return true;
	}

	private class LoginAsyncTask extends AsyncTask<Object, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			loginProgressBar = new ProgressBar(FunLoginActivity.this, null, android.R.attr.progressBarStyle);
			loginProgressBar.setVisibility(View.VISIBLE);
			// 登录时设置进度
			LayoutParams progressBarParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			progressBarParams.addRule(RelativeLayout.CENTER_IN_PARENT);
			if (!isShowQuickDialog) {

				loginRelativeLayout.addView(loginProgressBar, progressBarParams);
			}
		}

		@Override
		protected String doInBackground(Object... params) {

			HWUtils.logError(TAG, "params[0] = " + params[0]);

			Boolean isCurrentQuickLogin = false;
			if (params[0] instanceof Boolean) {
				isCurrentQuickLogin = Boolean.valueOf(params[0].toString());

			} else if (params[0] instanceof Integer) {
				loginMode = Integer.valueOf(params[0].toString());
			}
			if (!isShowQuickDialog) {

				userAccount = loginAccountTv.getText().toString();
				pwd = HWHttpResponse.stringToBase64(loginPwdTv.getText().toString());

			}

			hw_platform = HWUtils.getChannelCode(FunLoginActivity.this);

			// pwd = registPwdTv.getText().toString();
			//
			// rePwd = registRePwdTv.getText().toString();

			cpId = FunCellPlatformSdkApi.getInstance().mAppId;

			// HWUtils.logError(TAG, "getHWSign() = "
			// + getHWSign(isCurrentQuickLogin));

			HashMap<String, String> postData = new HashMap<String, String>();

			postData.put("cp_id", cpId);
			if (isCurrentQuickLogin) {
				// hw_refresh_token = userNameMap.get(userAccount);
				for (String key : infoMap.keySet()) {
					List<String> keyL = infoMap.get(userAccount);
					if (null != keyL) {
						hw_refresh_token = keyL.get(0);
					}
				}

				postData.put("grant_type", "quick");
				postData.put("refresh_token", hw_refresh_token);
				postData.put("username", userAccount);

			} else if (LOGIN_MODE_DEFAULT == loginMode) {
				postData.put("grant_type", "login");
				postData.put("password", pwd);// base64
				postData.put("username", userAccount);
			} else if (LOGIN_MODE_GUEST == loginMode) {
				postData.put("grant_type", "guest");

			}

			postData.put("platform", hw_platform);
			postData.put("sign", getHWSign(isCurrentQuickLogin));
			postData.put("ext_data", getHWExtData());

			// String responseData = null;
			String responseData = HWHttpResponse
					.doSendHttpPostResponse(HWUtils.getAuthUrl(FunLoginActivity.this) + "/authorize", postData);
			HWUtils.logError(TAG, "responseData = " + responseData);

			return responseData;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			// {"error_code":"A1005","message":"account
			// exist","level":"error","data":{"recommend_username":"qqqqq123"}}
			if (loginProgressBar != null)
				loginProgressBar.setVisibility(View.GONE);
			loginProgressBar = null;

			if (null == result) {
				defaultError();
				HWUtils.logError(TAG, "login response is null...");
				return;
			}

			Map<String, Object> responseDataMap = (Map<String, Object>) JsonObjectCoder.decode(result, null);
			if (responseDataMap == null) {
				defaultError();
				return;
			}
			String errorCode = null == responseDataMap.get("error_code") ? ""
					: responseDataMap.get("error_code").toString();
			if ("P1111".equals(errorCode)) {// success
				HWUtils.logError(TAG, "login success ,errorCode = " + errorCode);

				FunCellPlatformSdkApi.getInstance().setLogin(true);
				// 设置切换账号标志位--显示不同ui
				FunCellPlatformSdkApi.getInstance().setIsSwitchUser(false);

				Map<String, String> successDataMap = (Map<String, String>) responseDataMap.get("data");
				String hw_access_token = successDataMap.get("access_token");
				String hw_refresh_token = successDataMap.get("refresh_token");

				String guestUserName = successDataMap.get("username");
				String guestPwd = successDataMap.get("password");
				String guest = String.valueOf(successDataMap.get("guest"));
				final String adult = String.valueOf(successDataMap.get("adult"));

				fid = successDataMap.get("fid");
				if (null != guestUserName && 0 < guestUserName.trim().length()) {

					userAccount = guestUserName;
				}

				HWUtils.logError(TAG, "login success ,guestUserName = " + guestUserName + " , guestPwd = " + guestPwd);

				// 登录成功，保存用户
				HWFileUtils.saveQuick(userAccount, hw_refresh_token, hw_access_token);
				// 比较用户列表中是否有此键值
				saveLoginInfo(userAccount, hw_refresh_token, hw_access_token);

				String eventCode = LogTaskInfo.EVENT_CODE_USER_LOGIN;
				String accounType = "official";
				if (loginMode == 1) {// 游客模式
					Intent intent = new Intent(FunLoginActivity.this, FunPhotoActivity.class);
					intent.putExtra("token", hw_access_token);
					intent.putExtra("username", guestUserName);
					intent.putExtra("pwd", guestPwd);
					intent.putExtra("fid", fid);
					intent.putExtra("guest", guest);
					intent.putExtra("adult", adult);
					startActivity(intent);
					eventCode = LogTaskInfo.EVENT_CODE_USER_REGISTER;
					accounType = "guest";
					// 保存游客模式注册成功账号到txt
					// HWFileUtils.saveUserInfo(userAccount, hw_refresh_token,
					// hw_access_token);
				} else {
					if (mLoginCallBack != null) {

						mLoginCallBack.loginSuccess(hw_access_token, fid, guest, adult);

					}
				}
				// need real name authentication
				adult(adult);
				// 登录日志
				LogTaskInfo logTaskInfo = new LogTaskInfo();
				logTaskInfo.setEventCode(eventCode);
				logTaskInfo.setAccessToken(hw_access_token);

				Map<String, String> extDataMap = new HashMap<String, String>();
				extDataMap.put("account_type", accounType);
				String extData = JsonObjectCoder.encode(extDataMap, null);

				logTaskInfo.setExtData(extData);
				FunLogStatsUtils.submit(new FunLogStatsUtils.LogTaskRunnable(FunLoginActivity.this, logTaskInfo));

				// cps userlogin
				AtsLogTaskInfo atsLogTaskInfo = new AtsLogTaskInfo();
				atsLogTaskInfo.setMethod(AtsLogTaskInfo.ATS_METHOD_USER_LOGIN);
				atsLogTaskInfo.setIdentity(userAccount);

				FunLogStatsUtils.submit(new FunLogStatsUtils.AtsLogTaskRunnable(FunLoginActivity.this, atsLogTaskInfo));

				// 热云
				reyunLogin(userAccount);
				finish();

			} else if ("A1001".equals(errorCode) && !isShowQuickDialog) {// 账号不存在
				loginAccountTv.setError(
						getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_error_pwd")));
				loginAccountTv.requestFocus();
				HWUtils.logError(TAG, "account is not exist ,errorCode = " + errorCode);
			} else if ("A1002".equals(errorCode) && !isShowQuickDialog) {// 用户无权登录
				loginAccountTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_account_illegal")));
				loginAccountTv.requestFocus();
				HWUtils.logError(TAG, "account no permission ,errorCode = " + errorCode);
			} else if ("A1003".equals(errorCode) && !isShowQuickDialog) {// 密码错误
				loginAccountTv.setError(
						getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_error_pwd")));
				loginAccountTv.requestFocus();
				HWUtils.logError(TAG, "pwd is error ,errorCode = " + errorCode);
			} else if ("A1009".equals(errorCode) && !isShowQuickDialog) {// 账号格式错误
				loginAccountTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_account_format_error")));
				loginAccountTv.requestFocus();
				HWUtils.logError(TAG, "pwd is error ,errorCode = " + errorCode);
			} else if ("A1019".equals(errorCode) && !isShowQuickDialog) {// 账号格式错误
				loginAccountTv.setText("");
				loginAccountTv.setError(getResources()
						.getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_token_expired")));
				loginAccountTv.requestFocus();
				HWFileUtils.saveQuick(userAccount, "", "");
				HWUtils.logError(TAG, "token is expired ,errorCode = " + errorCode);
			} else {// 其他失败情况
				defaultError();
				HWUtils.logError(TAG, "login error ,errorCode = " + errorCode);
			}
		}

	};

	/**
	 * 
	 * @param act
	 */
	private void reyunLogin(String usreName) {

		TrackingIO.setLoginSuccessBusiness(usreName);
	}

	private void saveLoginInfo(String user, String refreshToken, String accessToken) {

		if (isInclude(user)) {

			HWFileUtils.saveUserInfo(user, refreshToken, accessToken);
		}
	}

	private boolean isInclude(String user) {

		if (null == userList) {// 快速登录时userList为false

			return false;
		}
		if (userList.size() == 0) {
			return true;
		}

		for (String listStr : userList) {
			if (user.equalsIgnoreCase(listStr)) {

				return false;
			}

		}
		return true;
	}

	private void defaultError() {

		if (loginAccountTv != null) {

			loginAccountTv.setError(
					getResources().getString(RUtils.string(FunLoginActivity.this, "fun_login_txt_error_fail")));
			loginAccountTv.requestFocus();
		} else {
			// 自动登录框失败提示
			FunCellPlatformSdkApi.getInstance().setIsSwitchUser(true);
			finish();
			Intent intent = new Intent(FunLoginActivity.this, FunLoginActivity.class);
			intent.putExtra("error", "error");
			FunLoginActivity.this.startActivity(intent);

		}
	}

	/**
	 * 获取ext_data参数
	 * 
	 * @return
	 */
	private String getHWExtData() {
		JSONObject extDataJSONObject = new JSONObject();
		try {
			extDataJSONObject.put("device_id", HWUtils.getImei(FunLoginActivity.this));
			extDataJSONObject.put("os", HWUtils.getPhoneVersion());
			extDataJSONObject.put("model", HWUtils.getPhoneModel());
			extDataJSONObject.put("network", HWUtils.getNetType(FunLoginActivity.this));
			extDataJSONObject.put("platform", hw_platform);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		HWUtils.logError(TAG, "extdata = " + extDataJSONObject.toString());

		return HWHttpResponse.stringToBase64(extDataJSONObject.toString());
	}

	/**
	 * 获取协议加密串
	 * 
	 * @return
	 */
	private String getHWSign(boolean isCurrentQuickLogin) {
		StringBuilder sign = new StringBuilder();
		sign.append("cp_id=").append(cpId).append("&");
		sign.append("ext_data=").append(getHWExtData()).append("&");
		if (isCurrentQuickLogin) {
			sign.append("grant_type=quick&");
			sign.append("platform=").append(hw_platform).append("&");
			sign.append("refresh_token=").append(hw_refresh_token).append("&");
			sign.append("username=").append(userAccount);

		} else if (LOGIN_MODE_DEFAULT == loginMode) {
			sign.append("grant_type=login&");
			sign.append("password=").append(pwd).append("&");
			sign.append("platform=").append(hw_platform).append("&");
			sign.append("username=").append(userAccount);
		} else if (LOGIN_MODE_GUEST == loginMode) {
			sign.append("grant_type=guest&");
			sign.append("platform=").append(hw_platform);

		}

		sign.append("#").append(FunCellPlatformSdkApi.getInstance().mAppKey);

		HWUtils.logError(TAG, "HWSign : " + sign.toString());

		return HWHttpResponse.stringTo32LowerCaseMD5(sign.toString());
	}

	public void setListViewHeightBasedOnChildren(ListView mListView) {

		ListAdapter listAdapter = mListView.getAdapter();

		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;

		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, mListView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = mListView.getLayoutParams();

		params.height = totalHeight + (mListView.getDividerHeight() * (listAdapter.getCount() - 1));

		int margin = HWUtils.dip2px(this, 10);

		((MarginLayoutParams) params).setMargins(margin, margin, margin, margin); // 可删除

		mListView.setLayoutParams(params);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		HWUtils.setWindowDisplayMode(FunLoginActivity.this, 280, 0.8f, 0.9f);

		if (null != pop && pop.isShowing()) {
			pop.dismiss();
			selectUserImageBtn.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_button"));
		}

	}

	/** 用于显示popupWindow内容的适配器 */
	class DropdownAdapter extends BaseAdapter {

		public DropdownAdapter(Context context, List<String> list) {
			this.context = context;
			this.list = list;
		}

		public int getCount() {
			return null == list || list.isEmpty() ? 0 : list.size();
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			final int currentPosition = position;
			if (null == convertView) {
				layoutInflater = LayoutInflater.from(context);
				convertView = layoutInflater.inflate(RUtils.layout(FunLoginActivity.this, "fun_list_row"), null);
			}
			close = (ImageButton) convertView.findViewById(RUtils.id(FunLoginActivity.this, "fun_close_row"));
			content = (TextView) convertView.findViewById(RUtils.id(FunLoginActivity.this, "fun_text_row"));
			final String editContent = list.get(position);
			content.setText(list.get(position).toString());

			if (null != list.get(position) && !TextUtils.isEmpty(loginAccountTv.getText())
					&& list.get(position).toString().equals(loginAccountTv.getText().toString())) {
				close.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_selected"));
				close.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						loginAccountTv.setText(editContent);
						pop.dismiss();
						selectUserImageBtn
								.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_button"));

						userAccount = editContent;

					}
				});

			} else {
				close.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_delete"));
				close.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// 删除键
						removeUserKey(editContent);
						// removeAccountDataFromList(currentPosition);
						adapter.notifyDataSetChanged();
					}
				});
			}

			content.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					isQuickLogin = true;// 选择下拉框中的账号密码，改变当前登录状态为快速登录
					loginAccountTv.setText(editContent);
					pop.dismiss();
					selectUserImageBtn
							.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_button"));
					userAccount = editContent;
				}
			});

			return convertView;
		}

		private Context context;
		private LayoutInflater layoutInflater;
		private List<String> list;
		private TextView content;
		private ImageButton close;
	}

	private ImageButton selectUserImageBtn;
	private List<String> nameList;
	private DropdownAdapter adapter;
	private PopupWindow pop;

	// 删除用户键值--删除指定用户名

	private void removeUserKey(String userName) {

		Iterator<String> it = userList.iterator();
		while (it.hasNext()) {

			if (it.next().equalsIgnoreCase(userName)) {
				it.remove();
			}
		}

		// 删除被点击删除用户图片按钮的用户键值信息
		Iterator<String> keyIt = infoMap.keySet().iterator();

		while (keyIt.hasNext()) {
			if (keyIt.next().equalsIgnoreCase(userName)) {
				keyIt.remove();// 删除当前键值信息
			}
		}
		// 将删除后的map信息写入文件
		HWFileUtils.saveChangeInfo(infoMap);

	}

	@Override
	protected void onStop() {
		super.onStop();
		if (null != pop) {
			pop.dismiss();
			pop = null;
			selectUserImageBtn.setImageResource(RUtils.drawable(FunLoginActivity.this, "fun_login_drop_button"));
		}
	}

	public void removeAccountDataFromList(int position) {

		if (null == nameList || nameList.isEmpty()) {
			return;
		}
		String userName = nameList.get(position);

		nameList.remove(position);

		userNameMap.remove(userName);

		String hwAccounts = null;
		String hwRefreshTokens = null;

		Set<Entry<String, String>> entrySet = userNameMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String name = entry.getKey();
			String reToken = entry.getValue();

			if (null == name || 0 == name.length()) {
				hwAccounts = name;
				hwRefreshTokens = reToken;
			} else {
				hwAccounts = hwAccounts + "," + name;
				hwRefreshTokens = hwRefreshTokens + "," + reToken;
			}
		}

		HWPreferences.addData(FunLoginActivity.this, "hw_accounts", hwAccounts);
		HWPreferences.addData(FunLoginActivity.this, "hw_refresh_tokens", hwRefreshTokens);

	}
}
