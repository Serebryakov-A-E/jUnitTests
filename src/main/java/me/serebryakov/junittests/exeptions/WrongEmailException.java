package me.serebryakov.junittests.exeptions;

public class WrongEmailException extends Exception {
    public WrongEmailException(String message) {
        super(message);
    }
}
