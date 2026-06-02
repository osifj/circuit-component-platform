package com.dlyjcsppydspt.utils;

public class ResultVoUtil {

    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;

    public static ResultVo success(Object data) {
        return new ResultVo(SUCCESS_CODE, "操作成功", data);
    }

    public static ResultVo success(String msg) {
        return new ResultVo(SUCCESS_CODE, msg, null);
    }

    public static ResultVo success(String msg, Object data) {
        return new ResultVo(SUCCESS_CODE, msg, data);
    }

    public static ResultVo error(String msg) {
        return new ResultVo(ERROR_CODE, msg, null);
    }

    public static ResultVo error(int code, String msg) {
        return new ResultVo(code, msg, null);
    }
}
