package ru.netology.qamid45.tests;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
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
import ru.netology.qamid45.steps.AboutSteps;
import ru.netology.qamid45.steps.AuthorizationSteps;
import ru.netology.qamid45.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки О приложении")
public class AboutTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationCheck() {
        AuthorizationSteps.authorization();
    }

    @AfterClass
    public static void exit() {
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }
    @Test
    @Story("# 55")
    @Description("Работа ссылки Политика конфиденциальности (Позитивный)")
    public void transitionPrivacyPolicy() {
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonPrivacyPolicy();
        //Выход
        pressBack();
    }

    @Test
    @Story("# 56")
    @Description("Работа ссылки Пользовательское соглашение (Позитивный)")
    public void transitionTermsOfUse() {
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonTermsOfUse();
        //Выход
        pressBack();
    }
}
