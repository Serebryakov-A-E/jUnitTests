package me.serebryakov.junittests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.serebryakov.junittests.exeptions.TheSameEmailAndLoginException;
import me.serebryakov.junittests.exeptions.WrongEmailException;

@Data
@NoArgsConstructor
public class User {
    private String login;
    private String email;

    public User(String login, String email) throws TheSameEmailAndLoginException, WrongEmailException {
        if (email.equals(login)) {
            throw new TheSameEmailAndLoginException("Login и email одинаковые");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new WrongEmailException("Неверный формат email");
        }
        this.login = login;
        this.email = email;
    }
}
