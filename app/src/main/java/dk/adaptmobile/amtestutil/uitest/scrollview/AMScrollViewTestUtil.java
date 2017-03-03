package dk.adaptmobile.amtestutil.uitest.scrollview;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static dk.adaptmobile.amtestutil.uitest.general.AMUITestUtil.findViewById;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMScrollViewTestUtil {

    public static void scrollToView(int id){
        findViewById(id).perform(scrollTo());
    }

    public static void scrollToViewAndClick(int id){
        findViewById(id).perform(scrollTo(), click());
    }

}
