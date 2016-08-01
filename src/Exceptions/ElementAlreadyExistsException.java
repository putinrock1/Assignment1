package Exceptions;

public class ElementAlreadyExistsException extends Exception {
    public ElementAlreadyExistsException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
