package me.heng.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午5:56
 */
public interface Loggable<L extends Logger> {

    default L getLogger(String logName){
        return (L) LoggerFactory.getLogger( logName);
    }

    default L getLogger(){
        return (L) LoggerFactory.getLogger(getClass());
    }
}
