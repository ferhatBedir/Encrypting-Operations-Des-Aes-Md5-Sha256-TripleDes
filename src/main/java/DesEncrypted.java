import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DesEncrypted {
    public static void main(String[] args) {

        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher;

            // Create the cipher
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = "Ferhat Bedir".getBytes();

            System.out.println("Metnin Byte Formatı : " + text);
            System.out.println("Text : " + new String(text));

            // AesEncrypted the text
            byte[] textEncrypted = desCipher.doFinal(text);

            System.out.println("Metnin Şifrelenmiş Hali : " + textEncrypted);

            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Metnin Şifresinin Çözülmüş Hali : " + new String(textDecrypted));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}

