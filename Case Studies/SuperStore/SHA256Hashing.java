package SuperStore;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hashing {

    public static String generateSHA256Hash(String i)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodeHash = digest.digest(i.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for(byte it : encodeHash)
            {
                String hex = Integer.toHexString(0xff & it);
                
                if(hex.length() == 1) hexString.append(0);
                hexString.append(hex);

            }
            return hexString.toString(); 
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
