package dk.adaptmobile.amtestutil.uitest.pickers;

import android.widget.DatePicker;
import android.widget.TimePicker;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.PickerActions.setDate;
import static android.support.test.espresso.contrib.PickerActions.setTime;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMPickerTestUtil {

    //make sure datepicker is visible when calling this method
    public static void selectDateInDatepicker(int dayOfMonth, int monthOfYear, int year) {
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(year, monthOfYear, dayOfMonth));
        onView(withId(android.R.id.button1)).perform(click());
    }

    public static void selectTimeInTimepicker(int hours, int minutes) {
        onView(isAssignableFrom(TimePicker.class)).perform(setTime(12, 36));
        onView(withId(android.R.id.button1)).perform(click());
    }

}
