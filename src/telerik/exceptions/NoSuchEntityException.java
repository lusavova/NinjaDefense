package telerik.exceptions;

import java.io.IOException;

public class NoSuchEntityException extends Exception {

    public NoSuchEntityException(String text) {
        super(text);
    }
}

