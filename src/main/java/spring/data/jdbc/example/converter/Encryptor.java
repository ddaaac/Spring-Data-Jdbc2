package spring.data.jdbc.example.converter;

public interface Encryptor {
    byte[] encrypt(String value);

    String decrypt(byte[] encrypted);
}
