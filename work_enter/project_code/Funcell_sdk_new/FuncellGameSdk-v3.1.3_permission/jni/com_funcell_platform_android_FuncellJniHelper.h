/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_funcell_platform_android_FuncellJniHelper */

#ifndef _Included_com_funcell_platform_android_FuncellJniHelper
#define _Included_com_funcell_platform_android_FuncellJniHelper
#ifdef __cplusplus
extern "C" {
#endif
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

#ifdef __cplusplus
}
#endif
#endif
