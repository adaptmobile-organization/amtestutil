package dk.adaptmobile.amtestutil.uitest.matchers;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMMatchers {

    // Selects first view when more than one are selected
    public static Matcher<View> first(final Matcher<View> matcher) {
        return withIndex(matcher, 0);
    }

    //Gives the opportunity to select view when more than one is selected
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static Matcher isNotDisplayed() {
        return not(isDisplayed());
    }

}
