package EPDs.EPD5;

public class EmptyQueueException extends Exception {
    public EmptyQueueException(String exc){
        super(exc);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
