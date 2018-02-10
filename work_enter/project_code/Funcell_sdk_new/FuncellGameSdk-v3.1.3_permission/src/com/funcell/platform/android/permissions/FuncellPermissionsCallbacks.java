package com.funcell.platform.android.permissions;

import java.util.List;

public interface FuncellPermissionsCallbacks {
    public abstract void onPermissionsGranted(int requestCode, List<String> perms);
    public abstract void onPermissionsDenied(int requestCode, List<String> perms);
}