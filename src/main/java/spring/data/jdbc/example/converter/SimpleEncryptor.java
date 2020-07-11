package spring.data.jdbc.example.converter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SimpleEncryptor implements Encryptor {
    private static final String MODE = "AES/CBC/PKCS5Padding";
    private static final SecretKeySpec KEY = new SecretKeySpec("asdfasd128bitkey".getBytes(), "AES");

    @Override
    public byte[] encrypt(final String value) {
        try {
            Cipher cipher = Cipher.getInstance(MODE);
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            return cipher.doFinal(value.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String decrypt(final byte[] encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(MODE);
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] decryptedText = cipher.doFinal(encrypted);
            return new String(decryptedText);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
