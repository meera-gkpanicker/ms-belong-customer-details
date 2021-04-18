package com.belong.ms.customer.details.exception;

import com.belong.ms.customer.details.api.Status;
import lombok.*;

@Getter
@Setter
public class CustomerDetailsException extends RuntimeException {

    private Status status;

    public CustomerDetailsException(String msg) { super(msg); }

    public CustomerDetailsException(String msg, Status status) {
        super(msg);
        this.status = status;
    }
}
