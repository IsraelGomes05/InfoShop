package com.sistnet.projeto.resources.exeptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{

    private static final long serialVersionUID = 1L;
    private List<FildMessage> errors = new ArrayList();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FildMessage> getErrors() {
        return errors;
    }

    public void addError(String fildName, String message) {
        this.errors.add(new FildMessage(fildName, message));
    }
}
