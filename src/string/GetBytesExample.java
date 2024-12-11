package src.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class GetBytesExample {
    public static void main(String[] args) {
        String str = "Hello, 你好，こんにちは";

        // 使用平台默认字符编码方式进行转换
        byte[] bytesDefault = str.getBytes();
        System.out.println("使用平台默认字符编码方式进行转换：");
        printBytes(bytesDefault);

        // 使用UTF-8字符编码方式进行转换
        try {
            byte[] bytesUTF8 = str.getBytes("UTF-8");
            System.out.println("\n使用UTF-8字符编码方式进行转换：");
            printBytes(bytesUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 使用ISO-8859-1字符编码方式进行转换
        try {
            byte[] bytesISO8859 = str.getBytes("ISO-8859-1");
            System.out.println("\n使用ISO-8859-1字符编码方式进行转换：");
            printBytes(bytesISO8859);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 打印字节数组的十六进制表示
    private static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xFF).toUpperCase() + " ");
        }
        System.out.println("---");
        System.out.println(Arrays.toString(bytes));
    }
}
