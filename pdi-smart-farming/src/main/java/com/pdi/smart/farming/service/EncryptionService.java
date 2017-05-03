package com.pdi.smart.farming.service;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ionutciuta24@gmail.com on 30.04.2017.
 */
@Component
public class EncryptionService {
    private static final String ALGORITHM = "MD5";

    public String encrypt(String input) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        return new String(hash);
    }
}
