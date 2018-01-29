package com.czf.base.utils;

import com.czf.base.common.Constant;
import com.sun.tools.internal.jxc.ap.Const;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", "0");
    }

    public Result(String code, String msg) {
        put("code", code);
        put("msg", msg);
    }

    public static Result error() {
        return new Result(Constant.RESULT.CODE_NO.getValue(), Constant.RESULT.MSG_NO.getValue());
    }

    public static Result error(String msg) {
        return error(Constant.RESULT.CODE_NO.getValue(), msg);
    }

    public static Result error(String code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    public static Result ok() {
        return new Result(Constant.RESULT.CODE_YES.getValue(), Constant.RESULT.MSG_YES.getValue());
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
