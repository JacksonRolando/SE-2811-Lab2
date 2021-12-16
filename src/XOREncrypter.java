import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XOREncrypter implements Encrypter {

    private byte[] key;

    public XOREncrypter(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] byteArray) {
        byte[] retArray = new byte[byteArray.length];

        byte[] compareKey;
        byte[] padZeros = new byte[byteArray.length - key.length];
        for(byte bite : padZeros) {
            bite = 0;
        }
        System.out.println(padZeros);
        try(ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream()){
            byteBuilder.write(padZeros);
            byteBuilder.write(key);
            compareKey = byteBuilder.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            compareKey = byteArray;
        }

        for(int i = 0; i < retArray.length; i++) {
            retArray[i] = (byte) (byteArray[i] ^ compareKey[i]);
        }

        return retArray;
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {
        return new byte[0];
    }
}
