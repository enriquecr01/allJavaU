package models.exceptions;

public class RecordNotFoundException extends Exception{
    //attributes
    private String message;
    //getters
    @Override
    public String getMessage() { return this.message; }
    //constructor
    public RecordNotFoundException(Object id) {
        this.message = "Record not found for id " + id.toString();
    }
}
