package dk.adaptmobile.amtestutil.uitest.scrollview;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMScrollViewTestUtil {

    private void scrollToView(int view){
        onView(withId(view)).perform(scrollTo());
    }

    private void scrollToViewAndClick(int view){
        onView(withId(view)).perform(scrollTo(), click());
    }

}
