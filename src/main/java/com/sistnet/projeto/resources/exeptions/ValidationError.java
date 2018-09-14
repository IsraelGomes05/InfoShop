package com.sistnet.projeto.resources.exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{

    private static final long serialVersionUID = 1L;
    private List<FildMessage> errors = new ArrayList();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FildMessage> getErrors() {
        return errors;
    }

    public void addError(String fildName, String message) {
        this.errors.add(new FildMessage(fildName, message));
    }
}
