package src.ch01;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class StringUtilities {
//    private static final Charset DEFAULT_CHARSET;

    public static String replace(String text, int start, int length, String replacement) {
        String rep = replacement == null ? "" : replacement;
        byte[] replaceBytes = rep.getBytes();
        if (replaceBytes.length > length) {
            throw new IllegalArgumentException(String.format("replacement sting %s has %d bytes, which is larger than request length %d.", replacement, replaceBytes.length, length));
        } else {
            if (replaceBytes.length < length) {
//                replaceBytes = extendByArray(replaceBytes, length, length, (byte)32);
            }

            String oldText = text == null ? "" : text;
            byte[] textBytes = oldText.getBytes();
            if (textBytes.length < start + length) {
//                textBytes = extendByArray(textBytes, start + length, (byte)32);
            }

            System.arraycopy(replaceBytes, 0, textBytes, start, length);
            return new String(textBytes);
        }
    }

}
