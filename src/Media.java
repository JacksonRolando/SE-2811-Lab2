import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class stores the data.
 *
 * Think of it as an SD card. Anyone can read the contents if they take it out and put it
 * somewhere else.
 */
public class Media {
    private byte[] bytes;

    public void set(byte[] bytes){
        this.bytes = bytes;
    }

    public void set(String hexadecimal) {
        Scanner lineScanner = new Scanner(hexadecimal);
        List<Byte> list = new ArrayList<>();
        while(lineScanner.hasNext()) {
            String word = lineScanner.next();
            try {
                byte data = (byte) Integer.parseInt(word,16);
                list.add(data);
            } catch(NumberFormatException e) {
                System.out.println("unexpected lineScanner.next() = " + word);
            }
        }
        bytes = new byte[list.size()];
        for(int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
    }

    public byte[] get() {
        return bytes;
    }

    public String toString() {
        StringBuilder encoding = new StringBuilder();
        for (byte b : bytes) {
            encoding.append(String.format("%02x ", b));
        }
        return encoding.toString();
    }
}
