package dk.adaptmobile.amtestutil.uitest.other;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by bjarkeseverinsen on 28/01/2017.
 */

public class SystemAnimations {

    private static final String ANIMATION_PERMISSION = "android.permission.SET_ANIMATION_SCALE";
    private static final float DISABLED = 0.0f;
    private static final float DEFAULT = 1.0f;

    private static SystemAnimations instance = null;
    private final Context context;

    private boolean animationsDisabled = false;

    private SystemAnimations(Context context) {
        this.context = context;
    }

    public static SystemAnimations getInstance(Context context) {
        if (instance == null) {
            instance = new SystemAnimations(context);
        }
        return instance;
    }

    public void disableAll() {
        if (animationsDisabled == false) {
            int permStatus = context.checkCallingOrSelfPermission(ANIMATION_PERMISSION);
            if (permStatus == PackageManager.PERMISSION_GRANTED) {
                setSystemAnimationsScale(DISABLED);
                animationsDisabled = true;
            }
        }
    }

    public void enableAll() {
        if (animationsDisabled == true) {
            int permStatus = context.checkCallingOrSelfPermission(ANIMATION_PERMISSION);
            if (permStatus == PackageManager.PERMISSION_GRANTED) {
                setSystemAnimationsScale(DEFAULT);
                animationsDisabled = false;
            }
        }
    }

    private void setSystemAnimationsScale(float animationScale) {
        try {
            Class<?> windowManagerStubClazz = Class.forName("android.view.IWindowManager$Stub");
            Method asInterface = windowManagerStubClazz.getDeclaredMethod("asInterface", IBinder.class);
            Class<?> serviceManagerClazz = Class.forName("android.os.ServiceManager");
            Method getService = serviceManagerClazz.getDeclaredMethod("getService", String.class);
            Class<?> windowManagerClazz = Class.forName("android.view.IWindowManager");
            Method setAnimationScales = windowManagerClazz.getDeclaredMethod("setAnimationScales", float[].class);
            Method getAnimationScales = windowManagerClazz.getDeclaredMethod("getAnimationScales");

            IBinder windowManagerBinder = (IBinder) getService.invoke(null, "window");
            Object windowManagerObj = asInterface.invoke(null, windowManagerBinder);
            float[] currentScales = (float[]) getAnimationScales.invoke(windowManagerObj);
            for (int i = 0; i < currentScales.length; i++) {
                currentScales[i] = animationScale;
            }
            setAnimationScales.invoke(windowManagerObj, new Object[]{currentScales});
        } catch (Exception e) {
            Log.e("SystemAnimations", "Could not change animation scale to " + animationScale + " :'(");
        }
    }
}