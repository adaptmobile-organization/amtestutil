package dk.adaptmobile.amtestutil.uitest.other;

/**
 * Created by bjarkeseverinsen on 28/01/2017.
 */

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


@LargeTest
@RunWith(AndroidJUnit4.class)
public abstract class AMBaseUITest {

    private static SystemAnimations systemAnimations;

    @BeforeClass
    public static void setupClass() throws IOException {
        Instrumentation instrumentation = getInstrumentation();
        UiDevice.getInstance(instrumentation).executeShellCommand(
                "pm grant " + instrumentation.getTargetContext().getPackageName() + " android.permission.SET_ANIMATION_SCALE");

        systemAnimations = SystemAnimations.getInstance(instrumentation.getContext());
        systemAnimations.disableAll();
    }

    @AfterClass
    public static void tearDownClass() {
        systemAnimations.enableAll();
    }


}
