package Exceptions;

public class FullListException extends Exception {
    public FullListException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
