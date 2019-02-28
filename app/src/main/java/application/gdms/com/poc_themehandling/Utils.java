package application.gdms.com.poc_themehandling;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.CompoundButton;

public class Utils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_WHITE = 1;
    public final static int THEME_BLUE = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.recreate();
        /*activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));*/
    }

    public static void changeToTheme(Context context,int theme) {
        sTheme = theme;
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.FirstTheme);
                break;
            case THEME_WHITE:
                activity.setTheme(R.style.SecondTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.Thirdheme);
                break;
        }
    }
}
