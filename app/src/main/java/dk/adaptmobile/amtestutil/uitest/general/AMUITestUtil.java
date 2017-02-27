package dk.adaptmobile.amtestutil.uitest.general;

import android.app.Instrumentation;
import android.support.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static dk.adaptmobile.amtestutil.uitest.matchers.AMMatchers.isNotDisplayed;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by bjarkeseverinsen on 26/01/2017.
 */

public class AMUITestUtil {

    public static ViewInteraction findViewById(int id) {
        return onView(allOf(withId(id)));
    }


    // ASSERTIONS //
    public static ViewInteraction assertView(int id, Matcher... matchers) {
        ViewInteraction view = findViewById(id);
        assertView(view, matchers);
        return view;
    }

    public static void assertView(ViewInteraction view, Matcher... matchers) {
        view.check(matches(allOf(matchers)));
    }

    public static void viewIsDisplayed(ViewInteraction view) {
        view.check(matches(isDisplayed()));
    }

    public static ViewInteraction viewIsDisplayed(int id) {
        ViewInteraction view = findViewById(id);
        viewIsDisplayed(view);
        return view;
    }

    public static void viewIsNotDisplayed(ViewInteraction view) {
        view.check(matches(isNotDisplayed()));
    }

    public static ViewInteraction viewIsNotDisplayed(int id) {
        ViewInteraction view = findViewById(id);
        viewIsNotDisplayed(view);
        return view;
    }

    public static void viewDoesNotExist(ViewInteraction view) {
        view.check(doesNotExist());
    }

    public static ViewInteraction viewDoesNotExist(int id) {
        ViewInteraction view = findViewById(id);
        viewDoesNotExist(view);
        return view;
    }

    public static void viewHasText(ViewInteraction view, int stringResource) {
        view.check(matches(withText(stringResource)));
    }

    public static void viewHasText(ViewInteraction view, String text) {
        view.check(matches(withText(text)));
    }

    public static ViewInteraction viewHasText(int id, int stringResource) {
        ViewInteraction view = findViewById(id);
        viewHasText(view, stringResource);
        return view;
    }

    public static ViewInteraction viewHasText(int id, String text) {
        ViewInteraction view = findViewById(id);
        viewHasText(view, text);
        return view;
    }

    public static ViewInteraction viewHasTextWithHtml(Instrumentation instrumentation, int id, int stringResource) {
        String text = instrumentation.getTargetContext().getResources().getString(stringResource);
        text = text.replaceAll("<br>", "\n");
        text = text.replaceAll("<br/>", "\n");
        text = text.replaceAll("<b>", "");
        text = text.replaceAll("</b>", "");
        text = text.replaceAll("<i>", "");
        text = text.replaceAll("</i>", "");
        ViewInteraction view = findViewById(id);
        viewHasText(view, text);
        return view;
    }

    // CLICKS //
    public static ViewInteraction clickView(int id) {
        ViewInteraction view = findViewById(id);
        clickView(view);
        return view;
    }

    public static void clickView(ViewInteraction view) {
        view.perform(click());
    }

    public static void pressKeyboardActionButton(ViewInteraction view) {
        view.perform(pressImeActionButton());
    }

}
