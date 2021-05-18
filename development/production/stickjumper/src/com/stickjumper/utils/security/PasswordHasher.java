package com.stickjumper.utils.security;

import com.stickjumper.utils.Settings;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHasher {

    private static byte[] salt = new byte[]{-71, 0, -54, 50, 22, -16, -67, -84, 36, 17, -31, -104, -23, -112, -77, 123};

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        long start, end;
        String passwordToHash = "DasIstEinTollesUndSicheresPasswort", hashed;
        start = System.currentTimeMillis();
        hashed = hash(passwordToHash);
        end = System.currentTimeMillis();
        Settings.logData("Hashed password: " + hashed);
        Settings.logData("Hashing took " + (end - start) + " ms");
    }

    public static String hash(String input) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 2048);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(hash);
    }

}
