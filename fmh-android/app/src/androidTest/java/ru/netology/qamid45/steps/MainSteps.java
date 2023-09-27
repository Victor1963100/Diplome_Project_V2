package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.netology.qamid45.elements.MainScreen.getMainElementsButtonAllNews;
import static ru.netology.qamid45.elements.MainScreen.getMainElementsButtonClaims;
import static ru.netology.qamid45.elements.WaitId.waitUntilElement;
import static ru.netology.qamid45.util.Util.nestedScrollTo;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainSteps {

    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        waitUntilElement(R.id.all_news_text_view);
        onView(getMainElementsButtonAllNews())
                .perform(click());
    }

    public static void clickButtonClaims(){
        Allure.step("Нажать на кнопку ВСЕ ЗАЯВКИ");
        waitUntilElement(R.id.all_claims_text_view);
        onView(getMainElementsButtonClaims ())
                .perform(nestedScrollTo())
                .perform(click());
    }
}
