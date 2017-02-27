package dk.adaptmobile.amtestutil.uitest.recyclerview;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static dk.adaptmobile.amtestutil.uitest.general.AMUITestUtil.findViewById;
import static dk.adaptmobile.amtestutil.uitest.matchers.RecyclerViewMatcherHelper.withChildRecyclerView;
import static dk.adaptmobile.amtestutil.uitest.matchers.RecyclerViewMatcherHelper.withRecyclerView;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMRecyclerViewTestUtil {

    public static ViewInteraction findViewByIdOnPositionInRecyclerView(int recyclerViewId, int position, int viewId) {
        return onView(withRecyclerView(recyclerViewId).atPositionOnView(position, viewId));
    }

    public static ViewInteraction assertRecyclerViewItem(int recyclerViewId, int position, int viewId, Matcher... matchers) {
        return onView(withRecyclerView(recyclerViewId).atPositionOnView(position, viewId)).check(matches(allOf(matchers)));
    }

    public static void performActionOnRecyclerViewPosition(ViewInteraction recyclerView, int position, ViewAction action) {
        recyclerView.perform(RecyclerViewActions.actionOnItemAtPosition(position, action));
    }

    public static void performActionsOnRecyclerViewPositionItem(int recyclerViewId, int position, int viewId, ViewAction... actions) {
        onView(withRecyclerView(recyclerViewId).atPositionOnView(position, viewId)).perform(actions);
    }

    public static void clickRecyclerViewPositionItem(int recyclerViewId, int position, int viewId) {
        performActionsOnRecyclerViewPositionItem(recyclerViewId, position, viewId, click());
    }

    public static void clickRecyclerViewPosition(ViewInteraction recyclerView, int position) {
        performActionOnRecyclerViewPosition(recyclerView, position, click());
    }

    public static void clickRecyclerViewPosition(int recyclerViewId, int position) {
        ViewInteraction recyclerView = findViewById(recyclerViewId);
        performActionOnRecyclerViewPosition(recyclerView, position, click());
    }

    //Recyclerview inside recyclerview
    public static ViewInteraction assertChildRecyclerViewItem(int parentRecyclerViewId, int parentPosition, int childRecyclerView, int childPosition, int viewId, Matcher... matchers) {
        return onView(withChildRecyclerView(parentRecyclerViewId, childRecyclerView).atPositionOnView(parentPosition, childPosition, viewId)).check(matches(allOf(matchers)));
    }

    public static ViewInteraction performActionOnChildRecyclerView(int parentRecyclerViewId, int parentPosition, int childRecyclerView, int childPosition, int viewId, ViewAction... actions) {
        return onView(withChildRecyclerView(parentRecyclerViewId, childRecyclerView).atPositionOnView(parentPosition, childPosition, viewId)).perform(actions);
    }

    //SCROLLS
    public static void scrollToPositionInRecyclerView(ViewInteraction recyclerView, int position) {
        recyclerView.perform(RecyclerViewActions.scrollToPosition(position));
    }

    public static void scrollToViewInRecyclerView(ViewInteraction recyclerView, int id) {
        recyclerView.perform(RecyclerViewActions.scrollTo(hasDescendant(withId(id))));
    }

    public static void scrollToViewInRecyclerView(ViewInteraction recyclerView, Matcher... matchers) {
        recyclerView.perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(matchers))));
    }
}
