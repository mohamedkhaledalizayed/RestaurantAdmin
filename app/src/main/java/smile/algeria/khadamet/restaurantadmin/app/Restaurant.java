package smile.algeria.khadamet.restaurantadmin.app;

import android.app.Application;
import smile.algeria.khadamet.restaurantadmin.utils.TypefaceUtil;

public class Restaurant extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Cairo-Regular.ttf");

    }
}
