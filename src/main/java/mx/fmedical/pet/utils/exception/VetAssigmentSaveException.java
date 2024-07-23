package mx.fmedical.pet.utils.exception;

public class VetAssigmentSaveException extends RuntimeException {

    public VetAssigmentSaveException(String message) {
        super(message);
    }

    public VetAssigmentSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
