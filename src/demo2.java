import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class demo2 {

    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};


    public static byte[] oldDecode(String str) {
        System.out.println(base64DecodeChars.length);
        byte[] data = str.getBytes();
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        int i = 0;

        while (i < len) {
            int b1;
            int b2;
            int b3;
            int b4;
            do {
                b1 = base64DecodeChars[data[(i++)]];
            }
            while ((i < len) && (b1 == -1));
            if (b1 == -1) {
                break;
            }

            do {
                b2 = base64DecodeChars[data[(i++)]];
            }
            while ((i < len) && (b2 == -1));
            if (b2 == -1) {
                break;
            }

            buf.write(b1 << 2 | (b2 & 0x30) >>> 4);
            do {
                b3 = data[(i++)];
                if (b3 == 61)
                    return buf.toByteArray();

                b3 = base64DecodeChars[b3];
            }
            while ((i < len) && (b3 == -1));
            if (b3 == -1)
                break;

            buf.write((b2 & 0xF) << 4 | (b3 & 0x3C) >>> 2);
            do {
                b4 = data[(i++)];
                if (b4 == 61)
                    return buf.toByteArray();

                b4 = base64DecodeChars[b4];
            }
            while ((i < len) && (b4 == -1));
            if (b4 == -1)
                break;

            buf.write((b3 & 0x3) << 6 | b4);
        }
        return buf.toByteArray();
    }
    final static Base64.Encoder encoder = Base64.getEncoder();
    public static void main(String[] args) {
//        String passwd = "Qq19950614*";
//        String text = null;
////        System.out.println(decode(passwd));
//        try {
//            text = new String(decode("MTIzNDU2"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(text);
        ;
        String text =("123456");
        byte[] textByte = new byte[0];
        try {
            textByte = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        System.out.println(encodeToString("Qq19950614*".getBytes()));
    }

    public static byte[] decode(String src) {
        return decode(src.getBytes());
    }

    public static byte[] decode(byte[] src) {
        byte[] dst = new byte[outLength(src.length)];
        int ret = decode0(src, 0, src.length, dst);
        if (ret != dst.length) {
            System.arraycopy(dst,0,dst,0,ret);
        }
        return dst;
    }

    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };
    private static final int[] fromBase64 = new int[256];

    static {
        Arrays.fill(fromBase64, -1);
        for (int i = 0; i < toBase64.length; i++)
            fromBase64[toBase64[i]] = i;
        fromBase64['='] = -2;
    }

    private static int decode0(byte[] src, int sp, int sl, byte[] dst) {
        boolean isMIME = false;
        int[] base64 = fromBase64;
        int dp = 0;
        int bits = 0;
        int shiftto = 18;       // pos of first byte of 4-byte atom
        while (sp < sl) {
            int b = src[sp++] & 0xff;
            if ((b = base64[b]) < 0) {
                if (b == -2) {         // padding byte '='
                    // =     shiftto==18 unnecessary padding
                    // x=    shiftto==12 a dangling single x
                    // x     to be handled together with non-padding case
                    // xx=   shiftto==6&&sp==sl missing last =
                    // xx=y  shiftto==6 last is not =
                    if (shiftto == 6 && (sp == sl || src[sp++] != '=') ||
                            shiftto == 18) {
                        throw new IllegalArgumentException(
                                "Input byte array has wrong 4-byte ending unit");
                    }
                    break;
                }
                if (isMIME)    // skip if for rfc2045
                    continue;
                else
                    throw new IllegalArgumentException(
                            "Illegal base64 character " +
                                    Integer.toString(src[sp - 1], 16));
            }
            bits |= (b << shiftto);
            shiftto -= 6;
            if (shiftto < 0) {
                dst[dp++] = (byte) (bits >> 16);
                dst[dp++] = (byte) (bits >> 8);
                dst[dp++] = (byte) (bits);
                shiftto = 18;
                bits = 0;
            }
        }
        // reached end of byte array or hit padding '=' characters.
        if (shiftto == 6) {
            dst[dp++] = (byte) (bits >> 16);
        } else if (shiftto == 0) {
            dst[dp++] = (byte) (bits >> 16);
            dst[dp++] = (byte) (bits >> 8);
        } else if (shiftto == 12) {
            // dangling single "x", incorrectly encoded.
            throw new IllegalArgumentException(
                    "Last unit does not have enough valid bits");
        }
        // anything left is invalid, if is not MIME.
        // if MIME, ignore all non-base64 character
        while (sp < sl) {
            if (isMIME && base64[src[sp++]] < 0)
                continue;
            throw new IllegalArgumentException(
                    "Input byte array has incorrect ending byte at " + sp);
        }
        return dp;
    }


    public static String encodeToString(byte[] src) {
        byte[] encoded = encode(src);
        return new String(encoded, 0, 0, encoded.length);
    }

    public static byte[] encode(byte[] src) {
        int len = outLength(src.length);          // dst array size
        byte[] dst = new byte[len];
        int ret = encode0(src, 0, src.length, dst);
        if (ret != dst.length)
            System.arraycopy(dst, 0, dst, 0, ret);
        return dst;
    }

    private static int outLength(int srclen) {
        int linemax = -1;
        boolean doPadding = true;
        byte[] newline = null;
        int len = 0;
        if (doPadding) {
            len = 4 * ((srclen + 2) / 3);
        } else {
            int n = srclen % 3;
            len = 4 * (srclen / 3) + (n == 0 ? 0 : n + 1);
        }
        if (linemax > 0)                                  // line separators
        {
            len += (len - 1) / linemax * newline.length;
        }
        return len;
    }

    private static int encode0(byte[] src, int off, int end, byte[] dst) {
        char[] base64 = base64EncodeChars;
        int sp = off;
        int slen = (end - off) / 3 * 3;
        int sl = off + slen;
        int linemax = -1;
        boolean doPadding = true;
        byte[] newline = null;
        if (linemax > 0 && slen > linemax / 4 * 3)
            slen = linemax / 4 * 3;
        int dp = 0;
        while (sp < sl) {
            int sl0 = Math.min(sp + slen, sl);
            for (int sp0 = sp, dp0 = dp; sp0 < sl0; ) {
                int bits = (src[sp0++] & 0xff) << 16 |
                        (src[sp0++] & 0xff) << 8 |
                        (src[sp0++] & 0xff);
                dst[dp0++] = (byte) base64[(bits >>> 18) & 0x3f];
                dst[dp0++] = (byte) base64[(bits >>> 12) & 0x3f];
                dst[dp0++] = (byte) base64[(bits >>> 6) & 0x3f];
                dst[dp0++] = (byte) base64[bits & 0x3f];
            }
            int dlen = (sl0 - sp) / 3 * 4;
            dp += dlen;
            sp = sl0;
            if (dlen == linemax && sp < end) {
                for (int i = 0; i < newline.length; i++) {
                    dst[dp] = newline[i];
                    dp++;
                }
            }
        }
        if (sp < end) {               // 1 or 2 leftover bytes
            int b0 = src[sp++] & 0xff;
            dst[dp++] = (byte) base64[b0 >> 2];
            if (sp == end) {
                dst[dp++] = (byte) base64[(b0 << 4) & 0x3f];
                if (doPadding) {
                    dst[dp++] = '=';
                    dst[dp++] = '=';
                }
            } else {
                int b1 = src[sp++] & 0xff;
                dst[dp++] = (byte) base64[(b0 << 4) & 0x3f | (b1 >> 4)];
                dst[dp++] = (byte) base64[(b1 << 2) & 0x3f];
                if (doPadding) {
                    dst[dp++] = '=';
                }
            }
        }
        return dp;
    }
}


