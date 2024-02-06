package h2project.demopractice.exceptions;

import org.springframework.http.HttpStatus;

public class CloudVendorException {

    String message;
    Throwable cause;
    HttpStatus httpStatus;

    public CloudVendorException(String message, Throwable cause, HttpStatus httpStatus) {
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
