/**
 * @author Troitskaya Tamara (cgsg-tt6)
 */
package exceptions;

/**
 * Infinite loop in 'execute_script'.
 */
public class InfiniteLoopException extends RuntimeException {
    public InfiniteLoopException(String message) {
        super(message + ": infinite loop.");
    }
}
