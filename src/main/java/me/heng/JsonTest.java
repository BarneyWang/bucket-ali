package me.heng;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.primitives.Bytes;

import java.util.Map;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/22
 * TIME: 下午6:10
 */
public class JsonTest {


    public static void main(String[] args) {
//
//        String str = "天猫、淘宝网、共享业务平台、中间件技术部、聚划算、商家业务、航旅事业部、集团客户服务、数字娱乐事业部、阿里影业、城市生活事业部";
//        System.out.println(str.contains("天猫"));
//        String str1 = "hades_docker";
//        System.out.println(str1.contains("docker"));

        String str = "{\"requestId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"data\":{\"status\":\"SUCCESS\",\"startTime\":1492082229000,\"endTime\":1492082550000,\"message\":\"调度成功, 分配过程: 磁盘空间不满足796台(例:11.173.197.71),禁止超卖限制不满足43台(例:11.173.160.8),CPU核数不满足8台(例:11.173.197.70),宿主机状态异常不满足1台(例:11.173.197.73)\",\"resultList\":[{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG8103Q0\",\"hostIp\":\"11.173.161.150\",\"slotId\":2,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173161150_2_792be0f24d5942\",\"containerHn\":\"passport-userservice011173202203.na62\",\"containerId\":\"2985ddac99f5847671ef783fee4f362bc34255712de4e874e3b856a9296efd1b\",\"containerName\":\"na62_passport-userservice011173202203_slotId_2\",\"containerIp\":\"11.173.202.203\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.202.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,31,62,30\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG81042G\",\"hostIp\":\"11.173.178.210\",\"slotId\":2,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178210_2_1d509d72801942\",\"containerHn\":\"passport-userservice011173207124.na62\",\"containerId\":\"13d50005e305406d649d26396bd7b65e96e438f9c282f272ce5f35c6552f3f24\",\"containerName\":\"na62_passport-userservice011173207124_slotId_2\",\"containerIp\":\"11.173.207.124\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.207.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,62,61,60\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG8102L0\",\"hostIp\":\"11.173.145.14\",\"slotId\":1,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173145014_1_9b2d30c1f5444c\",\"containerHn\":\"passport-userservice011173216238.na62\",\"containerId\":\"807e96ae56b7447cecab90f1fff6137119635d3ca48869355214dac8d792672d\",\"containerName\":\"na62_passport-userservice011173216238_slotId_1\",\"containerIp\":\"11.173.216.238\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.216.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"27,26,25,24\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG810375\",\"hostIp\":\"11.173.160.113\",\"slotId\":1,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173160113_1_d8cf12e88f4e4d\",\"containerHn\":\"passport-userservice011173221133.na62\",\"containerId\":\"d33a0c60130e903238f67011e16b7e1ffe80c7029f93e34c1e01c68750a2ba79\",\"containerName\":\"na62_passport-userservice011173221133_slotId_1\",\"containerIp\":\"11.173.221.133\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.221.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,62,61,60\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG8103QE\",\"hostIp\":\"11.173.178.16\",\"slotId\":2,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178016_2_b65e65b92b9e46\",\"containerHn\":\"passport-userservice011173181158.na62\",\"containerId\":\"1d22d741f9db512998e6e5e48a9e824d3a23dab1bf354e6318b812d3d3714256\",\"containerName\":\"na62_passport-userservice011173181158_slotId_2\",\"containerIp\":\"11.173.181.158\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.181.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,31,62,30\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG810423\",\"hostIp\":\"11.173.178.244\",\"slotId\":3,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178244_3_0f49cc063d9242\",\"containerHn\":\"passport-userservice011173187052.na62\",\"containerId\":\"9553bca8f7d0b64d560689ff235cba7102a4d711eb25b66145738878ce92e969\",\"containerName\":\"na62_passport-userservice011173187052_slotId_3\",\"containerIp\":\"11.173.187.52\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.187.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"61,29,60,28\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG81036D\",\"hostIp\":\"11.173.161.12\",\"slotId\":1,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173161012_1_85afd9317e2245\",\"containerHn\":\"passport-userservice011173170070.na62\",\"containerId\":\"0802b54c28970c669591c492432d8922017fb5d79d4f5f06e470b9f04010b007\",\"containerName\":\"na62_passport-userservice011173170070_slotId_1\",\"containerIp\":\"11.173.170.70\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.170.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,62,61,60\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG810413\",\"hostIp\":\"11.173.178.216\",\"slotId\":2,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178216_2_1c2b8f09990c4c\",\"containerHn\":\"passport-userservice011173187054.na62\",\"containerId\":\"ee3d47ed2bcc4b6e752285efbd78ed7d6d0aa031399eaf8108bdb500f74f4610\",\"containerName\":\"na62_passport-userservice011173187054_slotId_2\",\"containerIp\":\"11.173.187.54\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.187.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"63,31,62,30\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG8103Z1\",\"hostIp\":\"11.173.178.231\",\"slotId\":3,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178231_3_b9c2f461be6247\",\"containerHn\":\"passport-userservice011173207125.na62\",\"containerId\":\"366ec2541836603731cb9bd99933be5d57aadbc8b822b52efd26e909a7ed0f21\",\"containerName\":\"na62_passport-userservice011173207125_slotId_3\",\"containerIp\":\"11.173.207.125\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.207.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"59,58,57,56\",\"cpuQuota\":400,\"domain\":null},{\"resultCode\":0,\"errorMsg\":\"\",\"hostSn\":\"YG81040T\",\"hostIp\":\"11.173.178.241\",\"slotId\":3,\"requirementId\":\"3ab9eba5-767c-46ae-b230-47ccd348e1f1\",\"containerSn\":\"passport-userservice_011173178241_3_76c41348d0f741\",\"containerHn\":\"passport-userservice011173207126.na62\",\"containerId\":\"1f65e9d89f96807f5aedf430e44d83332d9065482d1b2e7403be0e3427081156\",\"containerName\":\"na62_passport-userservice011173207126_slotId_3\",\"containerIp\":\"11.173.207.126\",\"containerVlan\":\"701\",\"containerGw\":\"11.173.207.247\",\"containerMask\":\"255.255.255.0\",\"cpuSet\":\"61,29,60,28\",\"cpuQuota\":400,\"domain\":null}],\"total\":51},\"code\":0,\"message\":null,\"success\":true}";
//        str = str.replaceAll("\t", "");
//        str = str.replaceAll("\n", "");
//        str = str.replaceAll("  ", "");
//        str = str.trim();
//        System.out.println(str);
        System.out.println(str.length());
//       String test = Joiner.on(":").join("1","2",'3');
//       String test2 = Joiner.on(":").join("a","b","c");
//       String test3 = "1=a:2=b:3=c";
//       System.out.println(test3);
//       Splitter splitter = Splitter.on("|");
////       splitter.trimResults();
//        System.out.println("1");

        String str1 = "i-rj9hpd3tm0qnaryqij9g\n" +
                "i-rj9cnimtv9rciomgg96u\n" +
                "i-rj9gztdvr9nteh3mkt7x\n" +
                "i-rj92h06kutr4n8jm3oew\n" +
                "i-rj9dy7ntmpzweugblaho\n" +
                "i-rj9ed56dce2puje27e1l\n" +
                "i-rj9hxfsbworrhflm8xw3\n" +
                "i-rj9dy7ntmpzwfe6mpujt\n" +
                "i-rj9hxfsbworrhflm8xw2\n" +
                "i-rj941o6nb91jxtq9vtgf\n" +
                "i-rj92h06kutr4n8jm3oex\n" +
                "i-rj997n7xf5kg44y5h1gm\n" +
                "i-rj9ef1mjqu1s6n98swv2\n" +
                "i-rj9ai6pu0lpnq447srhf\n" +
                "i-rj9ih01h8fzet3irq3jz\n" +
                "i-rj9dy7ntmpzwfe6mpuju\n" +
                "i-rj94pvlm72odq55kvp0x\n" +
                "i-rj9ai6pu0lpnq447srhg\n" +
                "i-rj92h06kutr4n8jm3of0\n" +
                "i-rj9h7m2i6yqglyd81m51\n" +
                "i-rj94aqdxa2c05sdv9uw6\n" +
                "i-rj9iq8e7ya9v0gfgqgfk\n" +
                "i-rj9guhw2hqc66g7dbqys\n" +
                "i-rj9g0s7swgbn4avzsf7g\n" +
                "i-rj9e7qmu7j2367cjf2v8\n" +
                "i-rj96kdhrokmbj3aflxun\n" +
                "i-rj94lovr9900lp7sve3v\n" +
                "i-rj92h06kutr4n8jm3oez\n" +
                "i-rj9ai6pu0lpnq447srhh";
        str.replace("\n", ",");
        System.out.println(str1.replace("\n",","));
        System.out.println();

    }
}
