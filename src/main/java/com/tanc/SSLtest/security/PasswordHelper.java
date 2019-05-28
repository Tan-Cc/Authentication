package com.tanc.SSLtest.security;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.util.password.PasswordEncryptor;

import java.util.HashMap;
import java.util.Map;

public class PasswordHelper {

    public enum Type{
        SHA256_BASE64("SHA-256", "base64"),
        SHA256_HEX("SHA-256", "hexadecimal"),
        MD5_BASE64("MD5", "base64"),
        MD5_HEX("MD5", "hexadecimal");


        private String algorithm;
        private String outputType;

        private Type(String algorithm, String value) {
            this.algorithm = algorithm;
            this.outputType = value;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public String getOutputType() {
            return outputType;
        }
    }

    private final static class CustomPasswordEncryptor implements PasswordEncryptor {

        //提供match方法来检测原始数据和进行摘要计算后的数据是否匹配
        private final StandardStringDigester digester;

        public CustomPasswordEncryptor(String algorithm) {
            this.digester = new StandardStringDigester();
            this.digester.setAlgorithm(algorithm);
            this.digester.setIterations(1000);
            this.digester.setSaltSizeBytes(8);
        }

        public void setStringOutputType(final String stringOutputType) {
            this.digester.setStringOutputType(stringOutputType);
        }

        public String encryptPassword(final String password) {
            return this.digester.digest(password);
        }

        public boolean checkPassword(final String plainPassword,
                                     final String encryptedPassword) {
            System.out.println(plainPassword);
            System.out.println(encryptedPassword);
            return this.digester.matches(plainPassword,encryptedPassword);
        }
    }

    private static Map<Type, CustomPasswordEncryptor> passwordEncryptors = new HashMap<>();

    private PasswordHelper(){}

    private static PasswordEncryptor getPasswordEncryptor(final Type type) {
        if (passwordEncryptors.get(type) == null) {
            synchronized (passwordEncryptors) {
                if (passwordEncryptors.get(type) == null) {
                    CustomPasswordEncryptor customPasswordEncryptor =
                            new CustomPasswordEncryptor(type.getAlgorithm());
                    customPasswordEncryptor.setStringOutputType(type.getOutputType());

                    passwordEncryptors.put(type,customPasswordEncryptor);
                }
            }
        }

        return passwordEncryptors.get(type);
    }


    public static String encryptPassword(final String password) {
        return getPasswordEncryptor(Type.SHA256_BASE64).encryptPassword(password);
    }

    public static String encryptPassword(final String password, final Type type) {
        return getPasswordEncryptor(type).encryptPassword(password);
    }

    public static boolean checkPassword(final String plainPassword,
                                        final String encryptedPassword) {
        System.out.println(plainPassword);
        System.out.println(encryptedPassword);
        return getPasswordEncryptor(Type.SHA256_BASE64).checkPassword(plainPassword, encryptedPassword);
    }

    public static boolean checkPassword(final String plainPassword,
                                        final String encryptedPassword, final Type type) {
        return getPasswordEncryptor(type).checkPassword(plainPassword, encryptedPassword);
    }
}
