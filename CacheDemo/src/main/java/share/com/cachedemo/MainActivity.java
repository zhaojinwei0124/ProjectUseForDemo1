package share.com.cachedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import data.UserInfo;

public class MainActivity extends AppCompatActivity {
    ImageView h_head;
    EditText h_name;
    EditText h_pwd;
    ImageView x_head;
    EditText x_name;
    EditText x_pwd;
    public void initView(){
        h_head= (ImageView) findViewById(R.id.h_head);
        h_name= (EditText) findViewById(R.id.h_name);
        h_pwd= (EditText) findViewById(R.id.h_pwd);
        x_head= (ImageView) findViewById(R.id.x_head);
        x_name= (EditText) findViewById(R.id.x_name);
        x_pwd= (EditText) findViewById(R.id.x_pwd);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
}
