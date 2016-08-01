package Exceptions;

public class EmptyListException extends Exception {
    public EmptyListException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
