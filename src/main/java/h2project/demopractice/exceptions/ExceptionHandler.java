package h2project.demopractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value={CloudVendorNotFoundException.class})
    public ResponseEntity<Object> cloudVendorNotFoundExceptionHandler(CloudVendorNotFoundException cloudVendorNotFoundException)
    {
        CloudVendorException cloudVendorException=new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

                return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Object> detailsNotSavedExceptionHandler(DetailsNotSavedException detailsNotSavedException)
    {
        CloudVendorException cloudVendorException=new CloudVendorException(
                detailsNotSavedException.getMessage(),
                detailsNotSavedException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);

    }




}
