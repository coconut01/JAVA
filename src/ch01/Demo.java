package src.ch01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String Str1 = "阿斯蒂芬干活";

        try{
            byte[] Str2 = Str1.getBytes();
            System.out.println("返回值：" + Str2 );

            Str2 = Str1.getBytes("UTF-8" );
            System.out.println("返回值：" + Str2 );

            Str2 = Str1.getBytes("ISO-8859-1" );
            System.out.println("返回值：" + Str2 );
        } catch ( UnsupportedEncodingException e){
            System.out.println("不支持的字符集");
        }
    }
}
