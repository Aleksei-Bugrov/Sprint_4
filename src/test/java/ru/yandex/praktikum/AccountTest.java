package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name=name;
        this.expected=expected;
    }
    @Parameterized.Parameters
    public static Object[][] getStringValidation() {
        return new Object[][] {
                {"Тимоти Шаламе", true},         //позитивный тест(пт)
                {"тимоти шаламе", true},         //пт в нижнем регистре
                {"ТИМОТИ ШАЛАМЕ", true},         //пт в верхнем регистре
                {"Тимоти  Шаламе", false},       //негативный тест(нт), 2 пробела в середине
                {"Тимотишаламе", false},         //нт на наличие пробела
                {" Тимоти Шаламе", false},       //нт с пробелом вначале
                {"Тимоти Шаламе ", false},       //нт с пробелом в конце
                {"Т ", false},                   //нт с нижним граничным значением длины
                {"Т Ш", true},                   //пт с нижним граничным значением длины
                {"Тимоти Шаламеабвгде", true},   //пт с верхним граничным значением длины
                {"Тимоти Шаламеабвгдеж", false}, //нт с верхним граничным значением длины
                {"ё Ё", true},                   //пт с отдельно добавленными символами
                {"ая АЯ", true},                 //пт с граничным значением букв обоих регистров
        };
    }
    @Test
    public void validStringName() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
