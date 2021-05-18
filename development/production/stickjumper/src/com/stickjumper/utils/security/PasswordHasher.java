package com.stickjumper.utils.security;

import com.stickjumper.utils.Settings;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHasher {

    private static String hashCompare = "psyr5jObwthqdDElxUDJeDBWf8F0ZoGjVvgT8dMQ8G/bpYvYww3Q43fnsVEAtwxi2x0ehrwdlykES1nZnW/dzgyxVHBvX59IBFtDsWa9nTANlwX3QXXQfXrmiYDA9s245yL50nlofAYcJQkQ5RyMmEjAeMuqKSNtFyYXjowPaSKWtI9dp9n8wCTcDPf82iKsXQ8TNJqM7yjn7UrgL2mfK7onJToZA6kQaa9n/Lb0hYctghiicmv+zOIe+DKyq9zDXev2vNfygLTsUg3yc6/TmNZe5A9P/yNKnlKFEKat5YVVqs4yTzkxNkhBDRFf+54hbnYUH+Ddg9rT4WoQkzyGA/5PBqqFZGKUIus0nuoVsssJhbcI7z9vu13+xymVbCIGEa32E4z/siZ7kTc2S2t+AGg/Dxmu9T0CfIi8zs4+Lxu1AAB2u+lvLFK22xsksJEmuRww7oDwZqY4ZOAlVu8OHHAJsE31eu/b/MeL5ARlg8UqEnnKMzYJj9hDGbgWz1onwBLk8seTGzXXAmc27XvVneFXdDNnVXftbgDaEqLObwLWIqGD+2mvOVQIrojzC7srr9lax2VxWdR3sYMhvh3Zy4/h2ZkpKHGbJoh/xm/RTRPw99TbGl90/yNSRFuodLIWbzcYE8n4bual7087O4UjDGMX4nShHN26Br+t1mN7dXLbjjrzNjEqkrCqhLGFseAZ766tewVDVX2ZnjKov5RMyh+PO515gduq5zVu7FZDoQjIqTMbcnwNeXkMgE2FS4OdjgwBM8GxyQ9aT4Y15wXAgIR2apA5siIwp1JPpDmWHcdNomuNG5AwtOrQVlxebRQ8n5CJ1KA6dElbyIyAgMkWKQwAB1lL0s0aVFhvEsPcuHupjDc/9IKn5gdUdAR2Sbs4H5k5iDng4sphqqPr0dEZ/7b5uuI4oymYo9m/l9GD+6hY0n+B5CZvPqAR75UoCYQ6/ZA3Xm3CNYTkuJ7clmhBlh8svlPGE4h6AxbQspPGtIyMvvl+dutACtsVLyy8nEpj3E1TkgzJqnETVbU9Z1fyv9mugXQo+gnJDH3/MBh33OZ3IoIU8hC7W6DauluF4aWqWe7rrW30Pq1X6qwCEe1rol4L167DOR8RjQH0NxpT/3Ewc/sz0ajZV9HcEFbIZo8myzAnNopWE6iKVG4GtX0G7Pva9XvinEcGE1HR+gexqGchY/0ImXRSodYZPsGY4YXlUS0mlBnSK/aeLuJ/hM91AVwFXcr+aptxMVuS3gpjCKg0m8IfSediPMJC7Qp8sgUFPrwghqLzH/cCg+6/nNbA0UUjW9OCw04fMDR1K0cw86Rq2RIBLVavS5VDmSCsw7Vp4L3mocY+taHu8+lCUEQkUg==";
    private static byte[] salt = new byte[]{-71, 0, -54, 50, 22, -16, -67, -84, 36, 17, -31, -104, -23, -112, -77, 123};

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        long start, end;
        String passwordToHash = "DasIstEinTollesUndSicheresPasswort", hashed;
        start = System.currentTimeMillis();
        hashed = hash(passwordToHash);
        end = System.currentTimeMillis();
        Settings.logData("Hashed password: " + hashed);
        Settings.logData("Hashes are equal: " + hashed.equals(hashCompare));
        Settings.logData("Hashing took " + (end - start) + " ms");
    }

    public static String hash(String input) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 8192);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(hash);
    }

}
