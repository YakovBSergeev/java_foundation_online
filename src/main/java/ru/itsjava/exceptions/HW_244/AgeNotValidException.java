package ru.itsjava.exceptions.HW_244;

public class AgeNotValidException extends RuntimeException {
    public AgeNotValidException(String message) {
        super( message );
    }
}
