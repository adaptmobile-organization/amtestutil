package dk.adaptmobile.amtestutil.uitest.general;

import android.app.Instrumentation;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static dk.adaptmobile.amtestutil.uitest.matchers.AMMatchers.first;
import static dk.adaptmobile.amtestutil.uitest.matchers.AMMatchers.isNotDisplayed;
import static dk.adaptmobile.amtestutil.uitest.matchers.AMMatchers.withIndex;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

/**
 * Created by bjarkeseverinsen on 26/01/2017.
 */

public class AMUITestUtil {

    public static ViewInteraction findView(Matcher... matchers) {
        return onView(allOf(matchers));
    }

    public static ViewInteraction findViewById(int id) {
        return onView(allOf(withId(id), isDisplayed()));
    }

    public static ViewInteraction findViewByText(String text) {
        return onView(allOf(withText(text), isDisplayed()));
    }

    // ASSERTIONS //
    public static ViewInteraction assertView(int id, Matcher... matchers) {
        return assertView(findViewById(id), matchers);
    }

    public static ViewInteraction assertView(ViewInteraction view, Matcher... matchers) {
        return view.check(matches(allOf(matchers)));
    }

    public static ViewInteraction viewIsDisplayed(ViewInteraction view) {
        return view.check(matches(isDisplayed()));
    }

    public static ViewInteraction viewIsDisplayed(int id) {
        return viewIsDisplayed(findViewById(id));
    }

    public static ViewInteraction viewIsNotDisplayed(ViewInteraction view) {
        return view.check(matches(isNotDisplayed()));
    }

    public static ViewInteraction viewIsNotDisplayed(int id) {
        return viewIsNotDisplayed(findViewById(id));
    }

    public static ViewInteraction viewDoesNotExist(ViewInteraction view) {
        return view.check(doesNotExist());
    }

    public static ViewInteraction viewDoesNotExist(int id) {
        return viewDoesNotExist(findViewById(id));
    }

    public static ViewInteraction viewHasText(ViewInteraction view, int stringResource) {
        return view.check(matches(withText(stringResource)));
    }

    public static ViewInteraction viewHasText(ViewInteraction view, String text) {
        return view.check(matches(withText(text)));
    }

    public static ViewInteraction viewHasText(int id, int stringResource) {
        return viewHasText(findViewById(id), stringResource);
    }

    public static ViewInteraction viewHasText(int id, String text) {
        return viewHasText(findViewById(id), text);
    }

    public static ViewInteraction viewHasTextWithHtml(Instrumentation instrumentation, int id, int stringResource) {
        String text = instrumentation.getTargetContext().getResources().getString(stringResource);
        text = text.replaceAll("<br>", "\n");
        text = text.replaceAll("<br/>", "\n");
        text = text.replaceAll("<b>", "");
        text = text.replaceAll("</b>", "");
        text = text.replaceAll("<i>", "");
        text = text.replaceAll("</i>", "");
        return viewHasText(findViewById(id), text);
    }

    // CLICKS //
    public static ViewInteraction clickView(Matcher... matchers) {
        return clickView(findView(matchers));
    }

    public static ViewInteraction clickView(int id) {
        return clickView(findViewById(id));
    }

    public static ViewInteraction clickView(ViewInteraction view) {
        return view.perform(click());
    }

    public static ViewInteraction clickView(String text) {
        return clickView(findViewByText(text));
    }

    public static ViewInteraction clickFirstView(int id) {
        return clickView(findView(first(withId(id))));
    }

    public static ViewInteraction clickFirstView(String text) {
        return clickView(findView(first(withText(text))));
    }

    public static ViewInteraction clickFirstViewTextEndsWith(String text){
        return clickView(first(withText(endsWith(text))));
    }

    public static void pressKeyboardActionButton(ViewInteraction view) {
        view.perform(pressImeActionButton());
    }

    public static void swipeLeft(int id){
        findViewById(id).perform(ViewActions.swipeLeft());
    }

    public static void swipeRight(int id){
        findViewById(id).perform(ViewActions.swipeRight());
    }

    public static void swipeUp(int id){
        findViewById(id).perform(ViewActions.swipeUp());
    }

    public static void swipeDown(int id){
        findViewById(id).perform(ViewActions.swipeDown());
    }

}
