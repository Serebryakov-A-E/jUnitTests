package me.serebryakov.junittests.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UserTest {
    private static final String LOGIN = "Sasdsad";
    private static final String EMPTY_LOGIN = "";
    private static final String EMAIL = "Sasdsad@mail.ru";
    private static final String THE_SAME_EMAIL = "Sasdsad";
    private static final String WRONG_EMAIL = "Sasdsadmail.ru";
    private static final String WRONG_EMAIL2 = "Sasdsad@mail";

    private final String sing = "@";
    private final String dot = ".";


    public static Stream<Arguments> paramsForTest() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(LOGIN, EMAIL),
                Arguments.of(EMPTY_LOGIN, EMAIL),
                Arguments.of(LOGIN, THE_SAME_EMAIL),
                Arguments.of(LOGIN, WRONG_EMAIL),
                Arguments.of(LOGIN, WRONG_EMAIL2),
                Arguments.of(null, EMAIL),
                Arguments.of(EMPTY_LOGIN, null),
                Arguments.of(null, THE_SAME_EMAIL),
                Arguments.of(LOGIN, null),
                Arguments.of(null, WRONG_EMAIL2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void shouldReturnWriteLoginAndEmail(String login, String email) {
        User user = new User(login, email);
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertEquals(login, resultLogin);
        Assertions.assertEquals(email, resultEmail);
    }

    @Test
    public void shouldReturnNulls() {
        User user = new User();
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertNull(resultEmail);
        Assertions.assertNull(resultLogin);
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void shouldReturnCorrectEmail(String login, String email) {
        User user = new User(login, email);
        String resultEmail = user.getEmail();
        Assertions.assertTrue(resultEmail.contains(sing) && resultEmail.contains(dot));
        Assertions.assertEquals(resultEmail, user.getEmail());
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void emailAndLoginMustBeDifferent(String login, String email) {
        User user = new User(login, email);
        String resultEmail = user.getEmail();
        String resultLogin = user.getLogin();

        Assertions.assertNotEquals(resultEmail, resultLogin);
    }
}