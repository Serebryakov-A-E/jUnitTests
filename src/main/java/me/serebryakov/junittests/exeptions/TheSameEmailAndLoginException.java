package me.serebryakov.junittests.exeptions;

public class TheSameEmailAndLoginException extends Exception {
    public TheSameEmailAndLoginException(String message) {
        super(message);
    }
}
