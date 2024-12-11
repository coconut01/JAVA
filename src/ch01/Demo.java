package src.ch01;

import src.string.StringUtilities;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String str1 = "阿斯蒂芬干活";
        System.out.println(Arrays.toString(str1.getBytes(StandardCharsets.UTF_8)).length());

        String str2 = "123456";
        System.out.println(StringUtilities.replace(str2, 2, 3, "000"));
        System.out.println(StringUtilities.replace(str2, 8, 3, "000"));
        System.out.println(StringUtilities.replace("", 1, 3, "000"));


    }
}
