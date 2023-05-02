package diploma.backend.parcel.core.exception;

public class UserRegisteredException extends Exception {
    public UserRegisteredException() {
        super("Person with such username or email is registered");
    }
}
