package ru.netology.qamid45.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qamid45.elements.AuthorizationScreen;
import ru.netology.qamid45.steps.AuthorizationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Проведение функционального тестирования вкладки Авторизация")
public class AuthorizationTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationVerification() {
        try {
            AuthorizationScreen.textAuthorization();
        } catch (NoMatchingViewException e) {
            AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
            AuthorizationSteps.clickButtonLogOut();
        }
    }

    @Test
    @Story("# 1")
    @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
    public void successfulAuthorization() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    //  Авторизация с пустым полем "Логин"(Негативный).
    @Test
    @Story("# 2")
    @Description("Авторизация с пустым полем Login (Негативный)")
    public void loginFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginEmpty();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 3")
    @Description("Авторизация с полем Login, заполненным данными незарегистрированного пользователя (Негативный)")
    public void loginFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldUnregisteredUser();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 4")
    @Description("Авторизация при заполнении поля Login символами (Негативный)")
    public void loginFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 5")
    @Description("Поле Логин состоит из одного символа (Негативный)")
    public void loginFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldOneLetter();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 6")
    @Description("Поле Логин состоит из букв разного регистра (Негативный)")
    public void loginFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 7")
    @Description("Авторизация с пустым полем Password")
    public void passwordFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldIsEmpty();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 8")
    @Description("Поле Password заполнено данными незарегистрированного пользователя (Негативный)")
    public void passwordFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 9")
    @Description("Ввод символов в поле Password (Негативный)")
    public void passwordFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 10")
    @Description("Поле Password состоит из одного символа (Негативный)")
    public void passwordFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldOneLetter();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @Story("# 11")
    @Description("Поле Password состоит из букв разного регистра (Негативный)")
    public void passwordFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }
}
