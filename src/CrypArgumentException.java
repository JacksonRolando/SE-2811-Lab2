/**
 * This class represents an error that happens while running the CrypStick program.
 *
 * By using it, we are able to distinguish between errors that our code generates
 * and general Java errors that we do not anticipate.
 */
public class CrypArgumentException extends IllegalArgumentException {
    public CrypArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrypArgumentException(String s) {
        super(s);
    }

    public CrypArgumentException(Throwable cause) {
        super(cause);
    }
}
