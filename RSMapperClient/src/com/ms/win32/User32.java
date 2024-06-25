/*
 * Decompiled with CFR 0.152.
 */
package com.ms.win32;

import com.ms.dll.Callback;

public class User32 {
    public static native int SetWindowLong(int var0, int var1, int var2);

    public static native int GetWindowLong(int var0, int var1);

    public static native int CallWindowProc(Callback var0, int var1, int var2, int var3, int var4);

    public static native int SetCursor(int var0);

    public static int SetWindowLong(int i2, int i_6_, Callback callback) {
        return 0;
    }

    public static native boolean SetCursorPos(int var0, int var1);

    public static native int LoadCursor(int var0, int var1);

    public static native int SendMessage(int var0, int var1, int var2, Object var3);

    public static int CallWindowProc(int i2, int i_11_, int i_12_, int i_13_, int i_14_) {
        return 0;
    }

    public static int SetWindowLong(int i2, int i_15_, Object object) {
        return 0;
    }
}

