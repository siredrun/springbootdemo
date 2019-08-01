package com.sire.exception;

public class UserException extends RuntimeException{
    public UserException() {
        super("用户名不被允许使用");
    }
}
