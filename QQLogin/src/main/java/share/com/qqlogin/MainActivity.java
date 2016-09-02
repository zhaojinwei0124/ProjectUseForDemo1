package share.com.qqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class MainActivity extends AppCompatActivity {
    Button button;
    IUiListener miuiListener;
    public static final String APP_ID_FOR_TENCENT = "1105506561";
    public static final String APP_KEY_FOR_TENCENT = "Qy0ai0WXvvfd5AcE";
    public static Tencent tencent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.login);
        if (tencent == null) {
            tencent = Tencent.createInstance(APP_ID_FOR_TENCENT, this);
        }
        miuiListener=new IUiListener(){

            @Override
            public void onComplete(Object o) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

                String s=o.toString();
                Log.e("返回",s);
                Toast.makeText(MainActivity.this,o.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(UiError uiError) {

            }
            @Override
            public void onCancel() {

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               tencent.login(MainActivity.this, "all", miuiListener);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,miuiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
