package ru.gb.cart;

public class CartException extends RuntimeException{
    public CartException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartException(String message) {
        super(message);
    }
}
