//@authors Alex Csorba and Julian Powell
package war;

public class ULEmptyStackException extends RuntimeException {

    public ULEmptyStackException() {
        super();
    }

    public ULEmptyStackException(String message) {
        super(message);
    }

}
