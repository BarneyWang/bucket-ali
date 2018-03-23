package me.heng.function;

import com.google.common.base.Function;

/**
 * Created by chuanbao on 1/19/2016 AD.
 *
 * 异常处理
 *
 * apply返回true表示成功处理异常<br/>
 * 返回值用于控制程序流程
 */
public interface ExceptionHandler<T extends Exception> extends Function<T, Boolean> {
}
