package client;

public class UserNameAlreadyExistsException extends Exception {
    public UserNameAlreadyExistsException(String msg) {
        super(msg);
    }
}
