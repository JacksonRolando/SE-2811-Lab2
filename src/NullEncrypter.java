public class NullEncrypter implements Encrypter{

    @Override
    public byte[] encrypt(byte[] byteArray) {
        return byteArray;
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {
        return byteArray;
    }
}
