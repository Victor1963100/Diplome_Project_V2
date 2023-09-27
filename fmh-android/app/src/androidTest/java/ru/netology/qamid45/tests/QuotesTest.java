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
import ru.netology.qamid45.steps.QuotesSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки Тематические цитаты")
public class QuotesTest {

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
    @Story("# 54")
    @Description("Развернуть/свернуть вкладку с тематическими цитатами (Позитивный)")
    public void expandThematicQuote() {
        QuotesSteps.clickButtonThematicQuote();
        QuotesSteps.clickTitleThematicQuote();
        QuotesSteps.clickButtonExpandThematicQuote();
        QuotesSteps.clickDescriptionThematicQuote();
    }
}
