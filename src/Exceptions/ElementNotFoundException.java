package Exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
