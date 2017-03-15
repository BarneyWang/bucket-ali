package me.heng;

import com.google.common.base.Function;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/3
 * TIME: 上午10:03
 */
public class LambdaTest {



    private static String makeHostName(String ipAddr, String appName) {
        StringBuilder hostName = new StringBuilder();
        StringBuilder ip = new StringBuilder();
        String[] ipstrs = ipAddr.split("\\.");
        Arrays.stream(ipstrs).forEach(s -> {
            if (s.length() == 3) {
             ip.append(s);
            } else if (s.length() == 1) {
                ip.append(s+"00");
            } else if (s.length() == 2) {
                ip.append(s+"0");
            }

        });
        hostName.append(appName.replace("_", "")); // armory的主机名不允许有下划线
        hostName.append(ip);
        return hostName.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeHostName("127.0.0.1","wanfgdi"));
    }
}
