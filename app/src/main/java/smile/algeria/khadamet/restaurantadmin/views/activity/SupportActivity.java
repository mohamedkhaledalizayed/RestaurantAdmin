package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivitySupportBinding;
import smile.algeria.khadamet.restaurantadmin.utils.AppUtils;
import smile.algeria.khadamet.restaurantadmin.views.dialog.FeedbackDialog;
import smile.algeria.khadamet.restaurantadmin.views.dialog.SupportEmailDialog;

public class SupportActivity extends AppCompatActivity {

    private ActivitySupportBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_support);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.support));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendEmail(View view) {
//        FragmentManager fm = getSupportFragmentManager();
//        SupportEmailDialog editNameDialogFragment = SupportEmailDialog.newInstance();
//        editNameDialogFragment.show(fm, "Send Email Dialog");
//        editNameDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);

        AppUtils.sendMail(this,"Support@it-gds.com","Title");
    }

    public void callCenter(View view) {
        call("123456789");
    }

    public void supportChat(View view) {
        startActivity(new Intent(this,SupportChatActivity.class));
    }

    public void facebook(View view) {
        getOpenFacebookIntent();
    }

    public void getOpenFacebookIntent() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/mohamed.k.zayed.12"));
            startActivity(intent);
        } catch(Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/mohamed.k.zayed.12")));
        }
    }

    public void feedback(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FeedbackDialog editNameDialogFragment = FeedbackDialog.newInstance();
        editNameDialogFragment.show(fm, "Send Email Dialog");
        editNameDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
    }

    public void call(String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void whatsApp(View view) {
        String number="201141619993";

        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number)+"@s.whatsapp.net");
            startActivity(sendIntent);

        } catch(Exception e) {
            Log.e("Error", "ERROR_OPEN_MESSANGER"+e.toString());
        }
    }
}
