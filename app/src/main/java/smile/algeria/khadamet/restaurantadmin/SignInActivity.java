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
        finish();
    }

    public void signIn(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
