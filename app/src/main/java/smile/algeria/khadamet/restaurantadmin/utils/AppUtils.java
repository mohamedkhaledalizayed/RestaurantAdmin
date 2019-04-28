package smile.algeria.khadamet.restaurantadmin.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AppUtils {

    public static void sendMail(Context context, String email, String shareTitle) {
        try {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//            emailIntent.putExtra(Intent.EXTRA_TEXT, "Message");
            context.startActivity(emailIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
