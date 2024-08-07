package exceptions;

public class YearPublicationException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

	public YearPublicationException() {
        super();
    }

    public YearPublicationException(String message) {
        super(message);
    }

    public YearPublicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public YearPublicationException(Throwable cause) {
        super(cause);
    }
}
