package com.stickjumper.utils.security;

import com.stickjumper.utils.Settings;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHasher {

    private static final byte[] salt = new byte[]{-71, 49, -54, 50, 22, -16, -67, -84, 36, 17, -31, -104, -23, -112, -77, 123};

    public static String hash(String input) {
        KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            return enc.encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            Settings.logData("Error hashing password", e);
        }
        return null;
    }

}
