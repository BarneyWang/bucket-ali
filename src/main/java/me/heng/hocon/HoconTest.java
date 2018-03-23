package me.heng.hocon;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AUTHOR: wangdi
 * DATE: 22/01/2018
 * TIME: 10:57 AM
 */
public class HoconTest {
    private static final Logger logger = LoggerFactory.getLogger(HoconTest.class);

//    private static final Config config = ConfigFactory.load();

    private Config config;

    //指定配置文件
    public HoconTest(Config config) {
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "simple-lib");
    }

    // 默认加载classpath下的application.*
    public HoconTest() {
        this(ConfigFactory.load());
    }

    //打印
    public void printSetting(String path) {
        System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }

    public static void main(String[] args) {
//        HoconTest s = new HoconTest();
//        s.printSetting("simple-app.answer");
//        s.printSetting("simple-app.question");
//        s.printSetting("simple-app.isSuccess");
//        s.printSetting("simple-app.dd");
        String s = "cise-machine";
        System.out.println(true&&s.equalsIgnoreCase("-machine"));
    }

}
