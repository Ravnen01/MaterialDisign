package iutbg.lpiem.appsolutetest;

import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        TextInputLayout userEmail=(TextInputLayout) findViewById(R.id.userEmail);
        TextInputLayout userPassWord=(TextInputLayout) findViewById(R.id.userPasswordSingIn);
        getIntent().getStringExtra("etEmail");
        EditText etEmail=(EditText)findViewById(R.id.etEmail);
        etEmail.setText(getIntent().getStringExtra("etEmail"));
        final EditText etPassWord=(EditText)findViewById(R.id.etPassWordSignIn);
        etPassWord.setText(getIntent().getStringExtra("etPassWord"));
        final EditText etPassWordConfirm=(EditText)findViewById(R.id.etPassWordSignInConfirm);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            assert imageView != null;
            imageView.setTransitionName("imageView");
            assert userEmail != null;
            userEmail.setTransitionName("userEmail");
            assert userPassWord != null;
            userPassWord.setTransitionName("userPassWord");
        }

        Button button=(Button)findViewById(R.id.bAcheter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etPassWord.getText().toString().equals(etPassWordConfirm.getText().toString())){
                    etPassWordConfirm.setError("Mot de passe pas identique");
                }
            }
        });
    }
}
