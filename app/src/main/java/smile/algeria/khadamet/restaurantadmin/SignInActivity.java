package smile.algeria.khadamet.restaurantadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import smile.algeria.khadamet.restaurantadmin.views.activity.MainActivity;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signUp(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    public void signIn(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


//https://medium.freecodecamp.org/25-new-android-libraries-which-you-definitely-want-to-try-at-the-beginning-of-2017-45878d5408c0
    //https://github.com/Gwokhov/Deadline

}
