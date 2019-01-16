package me.heng.exeception;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-16
 * TIME: 19:24
 */
public class NestedExceptionTest {


    public static void test(){
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        try {
            test();
        }catch (Exception ex){
            test();
            System.out.println("11");
        }
    }
}
