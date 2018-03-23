package me.heng;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;

/**
 * AUTHOR: wangdi
 * DATE: 2017/11/17
 * TIME: 上午6:28
 */
public class TestCsv {


    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/wangdi/data2/3.csv"));//换成你的文件名
            String writefileName = "/Users/wangdi/data2/wdd3-r.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(writefileName));
//            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            Set<String> set = Sets.newHashSet();
            while((line=reader.readLine())!=null){
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String last = item[item.length-1].trim();//这就是你要的数据了
                BufferedReader reader2 = new BufferedReader(new FileReader("/Users/wangdi/data/mydata-1.txt"));//换成你的文件名
                String line2 = null;

                while((line2=reader2.readLine())!=null){
                    if(line2.startsWith(last)){
                        set.add(line2);
                    }else{
//                        System.out.println(line2+"||"+last);
                    }
                }
                reader2.close();
                BufferedReader reader3 = new BufferedReader(new FileReader("/Users/wangdi/data/mydata-2.txt"));//换成你的文件名
                String line3 = null;
                while((line3=reader3.readLine())!=null){
                    if(line3.startsWith(last)){
                        set.add(line3);
                    }else{
//                        System.out.println(line3+"||"+last);
                    }
                }
                reader3.close();
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
//                System.out.println(last);
            }


            for (String str : set) {
                System.out.println(str);
                writer.write(str+"\t\n");
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
