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
import ru.netology.qamid45.elements.ClaimsScreen;
import ru.netology.qamid45.steps.AuthorizationSteps;
import ru.netology.qamid45.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки Заявки")
public class ClaimsTest {

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
    @Story("# 14")
    @Description("Фильтрация заявок по критерию Открыта (Позитивный)")
    public void applicationFilteringInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @Story("# 15")
    @Description("Фильтрация заявок по критерию В работе (Позитивный)")
    public void applicationFilteringOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @Story("# 16")
    @Description("Фильтрация заявок по критерию Выполнена (Позитивный)")
    public void applicationFilteringExecuted() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @Story("# 17")
    @Description("Фильтрация заявок по критерию Отмененные (Позитивный)")
    public void applicationFilteringCancelled() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @Story("# 18")
    @Description("Создание заявки (Позитивный)")
    public void addNewClaim() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 19")
    @Description("При создании заявки поле Тема остается пустым (Негативный)")
    public void titleFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    @Test
    @Story("# 20")
    @Description("При создании заявки поле Тема состоит из одного символа (Негативный)")
    public void titleFieldOneCharacter() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldOneCharacter();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 21")
    @Description("При создании заявки поле Тема состоит из максимально-допустимого количества символов (Негативный)")
    public void titleFieldMaximumCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldMaximumCharacters();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 22")
    @Description("При создании завки поле Исполнитель остается пустым (Негативный)")
    public void executorFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 23")
    @Description("Ввод в поле Исполнитель русских букв и цифр при создании заявки (Негативный)")
    public void executorFieldOtherData() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldOtherData();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("№ 24")
    @Description("Ввод в поле Исполнитель других данных при создании заявки (Негативный)")
    public void executorFieldConsistsLettersAndNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldConsistsLettersAndNumbers();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 25")
    @Description("Ввод в поле Исполнитель символов при создании заявки (Негативный)")
    public void executorFieldSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldSpecialCharacters();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 26")
    @Description("Ввод в Поле Дата даты из будущего года при создании заявки (Позитивный)")
    public void descriptionFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateFieldNextYear();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 27")
    @Description("При создании заявки поле Описание остается пустым (Негативный)")
    public void dateFieldNextYear() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    @Test
    @Story("# 28")
    @Description("Редактирование заявки, находящейся в статусе Открыта (Позитивный)")
    public void editClaimStatusOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickEditClaim();
        ClaimsSteps.clickEditClaimStatusOpen();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 29")
    @Description("Добавление комментария к заявке (Позитивный)")
    public void addComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonAddComment();
        ClaimsSteps.clickCommentField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @Story("# 30")
    @Description("Редактирование комментария к заявке (Позитивный)")
    public void editComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonEditComment();
        ClaimsSteps.clickCommentField();
        ClaimsScreen.clickButtonSave();
    }

    @Test
    @Story("# 31")
    @Description("Смена статуса заявки, находящейся в статусе Открыта на статус В работе (Позитивный)")
    public void changeStatusOpenForInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonTakeToWork();
    }

    @Test
    @Story("# 32")
    @Description("Смена статуса заявки с истекшим сроком  исполнения, находящейся в статусе Открыта на статус В работе (Позитивный)")
    public void changeStatusOpenForInProgressExpired() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonTakeToWork();
    }
}
