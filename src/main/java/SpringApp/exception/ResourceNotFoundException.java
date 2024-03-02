package SpringApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Výjimka označující, že zdroj nebyl nalezen
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /**
     * Konstruktor pro vytvoření nové instance výjimky s danou zprávou
     * @param message - Zpráva popisující příčinu
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
