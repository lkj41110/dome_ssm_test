package web;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luokai on 2017/7/5.
 */
public class Result<T> {
    public static final String FAIL_CODE = "500";
    public static final String SUCCESS_CODE = "200";

    private boolean success = false;
    private Map<String, T> data = null;
    private String msg = "";
    private String code = "500";

    public Result() {
    }

    /**
     * 成功的时候
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result();
        r.setSuccess(true);
        r.setCode(SUCCESS_CODE);
        r.setData(data);
        r.setMsg("success");
        return r;
    }

    /**
     * 失败的时候
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String code, String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> Result<T> fail(String msg) {
        return fail(FAIL_CODE, msg);
    }

    public T getData() {
        if (data == null || data.isEmpty()) {
            return null;
        }
        for (String key : data.keySet()) {
            return data.get(key);
        }
        return null;
    }

    public T getData(String key) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        return data.get(key);
    }

    public Result<T> setData(T data) {
        Map<String, T> map = new HashMap<String, T>();
        map.put("result", data);
        this.data = map;
        return this;
    }

    public Result<T> setData(String key, T data) {
        Map<String, T> map = new HashMap<String, T>();
        map.put(key, data);
        this.data = map;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
