public class ShiftEncrypter implements Encrypter {
    private int amount;

    public ShiftEncrypter(int amount) {
        this.amount = amount;
    }

    @Override
    public byte[] encrypt(byte[] byteArray) {
        byte[] newArray = new byte[byteArray.length];
        byte newByte;
        for(int i = 0; i < newArray.length; i++) {
            int diff = 127 - byteArray[i];
            if(diff >= amount) {
                newArray[i] = (byte) (byteArray[i] + amount);
            } else {
                newArray[i] = (byte) (amount - diff - 1);
            }
        }
        return newArray;        //return shiftBytes(byteArray, bite -> (byte) (bite + amount));
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {
        byte[] newArray = new byte[byteArray.length];
        byte newByte;
        for(int i = 0; i < newArray.length; i++) {
            int diff = byteArray[i];
            if(diff >= amount) {
                newArray[i] = (byte) (byteArray[i] - amount);
            } else {
                newArray[i] = (byte) (127 - (amount - diff) + 1);
            }
        }
        return newArray;
    }

    private interface ByteChanger {
        byte changeByte(byte bite);
    }

    private byte[] shiftBytes(byte[] byteArray, ByteChanger changer) {
        byte[] newArray = new byte[byteArray.length];
        byte newByte;
        for(int i = 0; i < newArray.length; i++) {
            newByte = changer.changeByte(byteArray[i]);
            System.out.println(newByte);
        }
        return newArray;
    }

    /*
    private byte[] shiftBytes(byte[] byteArray, ByteChanger changer) {
        byte[] newArray = byteArray.clone();
        for(byte bite: newArray) {
            changer.changeByte(bite);
        }
        return newArray;
    }
     */
}
