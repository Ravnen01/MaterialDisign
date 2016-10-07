package iutbg.lpiem.appsolutetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        /*Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        TextView tvAddAccount=(TextView)findViewById(R.id.tvAddAccount);
        final ImageView imageView=(ImageView)findViewById(R.id.imageView);
        final Activity activity=this;
        assert tvAddAccount != null;
        tvAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignInActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    Pair<View, String> pair1 = Pair.create(findViewById(R.id.imageView), "imageView");
                    Pair<View, String> pair2 = Pair.create(findViewById(R.id.userEmail), "userEmail");
                    Pair<View, String> pair3 = Pair.create(findViewById(R.id.userPassWord), "userPassWord");
                    EditText etEmail=(EditText)findViewById(R.id.etEmail);
                    EditText etPassWord=(EditText)findViewById(R.id.etPassWord);
                    Bundle b=new Bundle();
                    assert etEmail != null;
                    b.putString("etEmail",etEmail.getText().toString());
                    assert etPassWord != null;
                    b.putString("etPassWord",etPassWord.getText().toString());
                    intent.putExtras(b);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity,pair1,pair2,pair3);
                    startActivity(intent, options.toBundle());
                }
                else {
                    startActivity(intent);
                }
            }
        });
    }
}
