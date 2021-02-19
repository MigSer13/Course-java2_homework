package ru.geekbrains.homework2;

public class MyArrayDataException extends NumberFormatException{
    private String message;

    public MyArrayDataException(String message) {
        super(message);
    }
}
