package ru.netology.qamid45.tests;

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
import ru.netology.qamid45.steps.AuthorizationSteps;
import ru.netology.qamid45.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Главная мобильного приложения Мобильный хоспис")
public class MainTest {

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
    @Story("# 12")
    @Description("Переход во вкладку News через главное меню (Позитивный)")
    public void buttonAllNews() {
        MainSteps.clickButtonAllNews();
    }

    @Test
    @Story("# 13")
    @Description("Переход во вкладку Claims через главное меню (Позитивный)")
    public void buttonAllClaims() {
        MainSteps.clickButtonClaims();
    }
}
