package ru.yandex.praktikum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        Pattern pattern = Pattern.compile("^(?=.{3,19}$)[а-яА-ЯёЁ]+\\s{1}[а-яА-ЯёЁ]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
