package com.example.demo.vo;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    private String code;
    private String message;
    private T body;

    public ResponseMessage<T> body(T body) {
        this.body = body;
        return this;
    }

    public ResponseMessage<T> success() {
        this.code = "200";
        this.message = "Success";
        return this;
    }

    public ResponseMessage<T> error() {
        this.code = "503";
        this.message = "Error";
        return this;
    }
}
