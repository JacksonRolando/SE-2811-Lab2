import java.nio.charset.StandardCharsets;

/**
 * Simple driver-based testing of the Media class.
 *
 * Test classes are one of the few places where duplicate code is a good thing.
 * Having duplicate code makes it clearer exactly what the test does.
 *
 * Each of the methods sets the byte contents either with the convenience
 * space-separated hexadecimal bytes String method (used for testing) or the
 * actual byte contents in an array. Then, the contents of the media objet are tested
 * through the .get() method which returns a bytes array and the .toString()
 * method which uses the testing space-separated hexadecimal format.
 *
 * Except where noted, the tests should not report any issues to the console in any format,
 * either to System.out or to System.in.  If these tests do not pass before starting your
 * implementation, please consult with your instructor.
 */
public class MediaDriver {
    public static void main(String[] args) {

        Media media = new Media();
        System.out.println("First message. Setting hex contents from a formatted string of " +
                "space-separated bytes.");
        media.set("43 61 62");
        System.out.println("media.get() (\"ascii\")) = " + new String(media.get(),
                StandardCharsets.US_ASCII));
        System.out.println("media = " + media);

        System.out.println();
        System.out.println("Second message. Setting bytes directly from a byte array.");
        byte nextMessage[] = "asdfasdf".getBytes(StandardCharsets.US_ASCII);
        media.set(nextMessage);
        System.out.println("media.get() (\"ascii\")) = " + new String(media.get(),
                StandardCharsets.US_ASCII));
        System.out.println("media = " + media);

        System.out.println();
        System.out.println("Third message. Similar to the first, but with a newline in the text.");
        media.set("41 35 37 0A 44 61 64");
        System.out.println("media.get() (\"ascii\")) = " + new String(media.get(),
                StandardCharsets.US_ASCII));
        System.out.println("media = " + media);

        System.out.println();
        System.out.println("Fourth message. Testing with non-ASCII bytes.");
        media.set("7E FF 7F AB");
        System.out.println("media.get() (\"ascii\")) = " + new String(media.get(),
                StandardCharsets.US_ASCII));
        System.out.println("media = " + media);

        System.out.println();
        System.out.println("Fifth message. Testing with non-bytes given, which should be dropped " +
                "with a warning from the set method.");
        media.set("7E notabyte 7F AlsoNot");
        System.out.println("media.get() (\"ascii\")) = " + new String(media.get(),
                StandardCharsets.US_ASCII));
        System.out.println("media = " + media);

    }
}
