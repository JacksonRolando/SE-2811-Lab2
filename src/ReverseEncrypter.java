public class ReverseEncrypter implements Encrypter{

    @Override
    public byte[] encrypt(byte[] byteArray) {
        return reverse(byteArray);
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {
        return reverse(byteArray);
    }

    private byte[] reverse(byte[] byteArray) {
        byte[] retArray = new byte[byteArray.length];
        for(int i = byteArray.length - 1; i >= 0 ; i--) {
            retArray[byteArray.length - 1 - i] = byteArray[i];
        }
        return retArray;
    }
}
