package me.heng.exeception;

import com.alibaba.fastjson.JSON;
import me.heng.beans.Beans;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:57
 */
public class GenericException extends RuntimeException {

    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericException(Throwable cause) {
        super(cause);
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    /**
     * 将 bean类型对象转成json格式
     *
     * @param fmt
     * @param objs
     * @return
     */
    public static String format(String fmt, Object... objs) {
        String line = fmt;
        if (objs != null && objs.length > 0) {
            Object[] str = new Object[objs.length];
            for (int i = 0; i < objs.length; i++) {
                if (Beans.isBean(objs[i])) {
                    str[i] = JSON.toJSONString(objs[i]);
                } else
                    str[i] = objs[i];
            }
            line = String.format(fmt, objs);
        }
        return line;
    }
}
