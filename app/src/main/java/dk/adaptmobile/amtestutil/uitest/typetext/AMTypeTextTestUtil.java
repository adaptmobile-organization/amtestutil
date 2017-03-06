package dk.adaptmobile.amtestutil.uitest.typetext;

import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static dk.adaptmobile.amtestutil.uitest.general.AMUITestUtil.findViewById;

/**
 * Created by bjarkeseverinsen on 27/02/2017.
 */

public class AMTypeTextTestUtil {

    public static void typeTextInView(int viewId, String text, boolean closeKeyboardAfterwards) {
        typeTextInView(findViewById(viewId), text, closeKeyboardAfterwards);
    }

    public static void typeTextInView(ViewInteraction view, String text, boolean closeKeyboardAfterwards) {
        //ESPRESSO DOES NOT HANDLE Æ, Ø, Å, use replaceText instead if you HAVE TO test words with these chars

        String lowerCaseText = text.toLowerCase();
        boolean containsDanishLetter = lowerCaseText.contains("æ") || lowerCaseText.contains("ø") || lowerCaseText.contains("å");

        if (!containsDanishLetter) {
            view.perform(typeText(text));
        } else {
            view.perform(replaceText(text));
        }

        if (closeKeyboardAfterwards) {
            closeKeyBoard(view);
        }
    }

    public static void closeKeyBoard(ViewInteraction view) {
        view.perform(closeSoftKeyboard());
    }
}