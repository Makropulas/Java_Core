package gb.javacore.dz4.task1;

public class WrongIdentificationException extends Exception {
    public WrongIdentificationException(String message) {
        super(message);
    }

    public WrongIdentificationException() {
    }
}

class WrongLoginException extends WrongIdentificationException {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException() {
    }
}

class WrongPasswordException extends WrongIdentificationException {
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
    }
}
