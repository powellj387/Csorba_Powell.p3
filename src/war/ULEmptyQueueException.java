//@authors Alex Csorba and Julian Powell
package war;

public class ULEmptyQueueException extends RuntimeException {

    public ULEmptyQueueException() {
        super();
    }

    public ULEmptyQueueException(String message) {
        super(message);
    }

}
