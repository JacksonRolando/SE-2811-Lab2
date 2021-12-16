import java.nio.charset.StandardCharsets;

/**
 * This class represents the USB stick.
 *
 * It accepts a message and stores it to the internal media.
 *
 * Think of it as a "secure SD card" adapter.
 */
public class CrypStick {
    private Media media;
    private Encrypter encryptionStrategy;

    /* TODO: Update the fields and constructor as needed. */
    public CrypStick(Encrypter encryptionStrategy) {
        media = new Media();
        this.encryptionStrategy = encryptionStrategy;
    }

    public void setMessage(String message) {
        byte[] plaintext = message.getBytes(StandardCharsets.UTF_8);

        /* TODO: The next line is clearly not the best way of handling secure data.... */
        byte[] ciphertext = encryptionStrategy.encrypt(plaintext);
        media.set(ciphertext);
    }

    public String getMessage() {
        byte[] ciphertext = media.get();

        /* TODO: The next line is clearly not the best way of handling secure data.... */
        byte[] plaintext = encryptionStrategy.decrypt(ciphertext);
        return new String(plaintext,StandardCharsets.UTF_8);
    }

    protected Media getMedia() {
        return media;
    }
}
