package src.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringUtilities {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static String replace(String text, int start, int length, String replacement) {
        String rep = replacement == null ? "" : replacement;
        byte[] replaceBytes = rep.getBytes(DEFAULT_CHARSET);
        if (replaceBytes.length > length) {
            throw new IllegalArgumentException(String.format("replacement sting %s has %d bytes, which is larger than request length %d.", replacement, replaceBytes.length, length));
        } else {
            if (replaceBytes.length < length) {
                replaceBytes = extendByArray(replaceBytes, length, (byte)32);
            }

            String oldText = text == null ? "" : text;
            byte[] textBytes = oldText.getBytes(DEFAULT_CHARSET);
            if (textBytes.length < start + length) {
                textBytes = extendByArray(textBytes, start + length, (byte)32);
            }

            System.arraycopy(replaceBytes, 0, textBytes, start, length);
            return new String(textBytes);
        }
    }

    public static byte[] extendByArray(byte[] bytes, int length, byte fillter) {
        byte[] extended = new byte[length];
        System.arraycopy(bytes, 0, extended, 0, Math.min(bytes.length, length));

        if (bytes.length < length) {
            for (int i = bytes.length; i < length; ++i) {
                extended[i] = fillter;
            }
        }

        return extended;
    }

}
