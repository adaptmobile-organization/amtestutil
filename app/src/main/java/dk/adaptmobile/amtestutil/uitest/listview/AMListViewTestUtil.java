package dk.adaptmobile.amtestutil.uitest.listview;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMListViewTestUtil {

    public static void assertListViewItemAtPosition(int listView, int position, Matcher... matchers) {
        onData(anything())
                .inAdapterView(withId(listView))
                .atPosition(position).check(matches(allOf(matchers)));
    }

    public static void clickListViewItemAtPostition(int listView, int position) {
        onData(anything())
                .inAdapterView(withId(listView))
                .atPosition(position)
                .perform(click());
    }

    public static void assertListViewChildItemAtPosition(int listView, int position, int childView, Matcher... matchers) {
        onData(anything())
                .inAdapterView(withId(listView))
                .atPosition(position).onChildView(withId(childView)).check(matches(allOf(matchers)));
    }

    public static void clickListViewChildItemAtPosition(int listView, int position, int childView) {
        onData(anything())
                .inAdapterView(withId(listView))
                .atPosition(position).onChildView(withId(childView))
                .perform(click());
    }

}
