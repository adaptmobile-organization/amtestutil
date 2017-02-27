package dk.adaptmobile.amtestutil.uitest.scrollview;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMScrollViewTestUtil {

    public static void scrollToView(int view){
        onView(withId(view)).perform(scrollTo());
    }

    public static void scrollToViewAndClick(int view){
        onView(withId(view)).perform(scrollTo(), click());
    }

}
