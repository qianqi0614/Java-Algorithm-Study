public class EncryptionImp {
    private byte[] seed1;
    private byte[] seed2;

    public EncryptionImp() {
        this.seed1 = "WondErS".getBytes();
        this.seed2 = "CuTeInFo".getBytes();
    }

    public String MD5Crypt(final String str) {
        return null;
    }

    public String SHA1Crypt(final String str) {
        return null;
    }

    public String DESCrypt(final String str) throws Exception {
        final StringBuffer en = new StringBuffer("");
        final byte[] b = str.getBytes();
        for (int i = 0; i < b.length; ++i) {
            final int c = b[i] ^ this.seed1[i % this.seed1.length] ^ this.seed2[i % this.seed2.length];
            if (i > 0) {
                en.append(",");
            }
            en.append(String.valueOf(c));
        }
        return en.toString();
    }

    public String DESDecrypt(final String str) throws Exception {
        final String[] s = str.split(",");
        if (s.length == 0) {
            return "";
        }
        final byte[] b = new byte[s.length];
        for (int i = 0; i < s.length; ++i) {
            int c = Integer.parseInt(s[i]);
            c = (c ^ this.seed2[i % this.seed2.length] ^ this.seed1[i % this.seed1.length]);
            b[i] = (byte)c;
        }
        return new String(b);
    }
}
