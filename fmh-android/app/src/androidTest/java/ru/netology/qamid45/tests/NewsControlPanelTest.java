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
import ru.netology.qamid45.elements.NewsControlPanelScreen;
import ru.netology.qamid45.steps.AuthorizationSteps;
import ru.netology.qamid45.steps.ClaimsSteps;
import ru.netology.qamid45.steps.NewsControlPanelSteps;
import ru.netology.qamid45.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования Панели Управления Новостями")

public class NewsControlPanelTest {

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
    @Story("# 37")
    @Description("Сортировка новостей (Позитивный)")
    public void sortingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelScreen.clickButtonControlPanel();
        NewsControlPanelScreen.clickButtonSorting();
    }

    @Test
    @Story("# 38")
    @Description("Просмотр новостей (Позитивный)")
    public void viewingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
    }

    @Test
    @Story("# 39")
    @Description("Удаление активной новости (Позитивный)")
    public void deletingActiveNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonDeleteNews();
        NewsControlPanelSteps.clickOkDeleteNews();
    }

    @Test
    @Story("# 40")
    @Description("Редактирование новости (Позитивный)")
    public void editNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonTitleNewsControlPanel();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    @Test
    @Story("# 41")
    @Description("Смена статуса новости, находящейся в статусе Активна, на статус Не активна (Позитивный)")
    public void statusChangeNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonSwitcher();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    @Test
    @Story("# 42")
    @Description("Фильтрация новостей по критерию Активна (Позитивный)")
    public void filterNewsByCriterionActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

    @Test
    @Story("# 43")
    @Description("Фильтрация новостей по критерию Не активна (Позитивный)")
    public void filterNewsByCriterionNotActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxNotActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

    @Test
    @Story("# 44")
    @Description("Создание новости (Позитивный)")
    public void creationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        NewsControlPanelSteps.clickButtonAllNews();
    }

    @Test
    @Story("# 45")
    @Description("При создании новости поле Категория остается пустым (Негативный)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 46")
    @Description("При создании новости поле Заголовок остается пустым (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNew();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 47")
    @Description("При создании новости поле Дата публикации остается пустым (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 48")
    @Description("При создании новости поле Время остается пустым (Негативный)")

    public void fieldTimeEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 49")
    @Description("При создании новости поле Описание остается пустым (Негативный)")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 50")
    @Description("Ввод в поле Категория собственного названия категории при создании новости (Негативный)")
    public void customCategoryName() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsEmpty();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    @Test
    @Story("# 51")
    @Description("Ввод в поле Категория цифр при создании новости (Негативный)")
    public void fieldCategoryConsistsOfNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsNumbers();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    @Test
    @Story("# 52")
    @Description("Ввод в поле Категория символов при создании новости (Негативный)")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingCharacters();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @Story("# 53")
    @Description("Ввод в поле Дата публикации даты из будущего года при создании новости (Позитивный)")
    public void fieldDateConsistsOfNextYearCreatingNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
    }
}
