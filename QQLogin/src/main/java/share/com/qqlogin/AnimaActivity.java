package share.com.qqlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class AnimaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima);
    }
    public void onClick(View view){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        view.startAnimation(animation);
    }
}
