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
import ru.netology.qamid45.steps.ClaimsSteps;
import ru.netology.qamid45.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки Новости")
public class NewsTest {

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
    @Story("# 33")
    @Description("Просмотр новостей во вкладке Новости (Позитивный)")
    public void viewingNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickExpandNews();
    }

    @Test
    @Story("# 34")
    @Description("Сортировка новостей во вкладке Новости (Позитивный)")
    public void newsSorting() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonSorting();
    }

    @Test
    @Story("# 35")
    @Description("Фильтрация новостей без указания категории (Позитивный)")
    public void filteringNewsNoCategoryPositive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonCategoryFilter();
    }

    @Test
    @Story("# 36")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени (Позитивный)")
    public void filteringNewsCertainPeriodTime() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
    }
}
