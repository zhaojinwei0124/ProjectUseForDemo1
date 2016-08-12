package share.com.intentobj2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWeb(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //URI的组成形式：scheme://host:port/path?pattern
        Uri data = Uri.parse("http://www.qjyfj.com/Article_Class.asp?ClassID=1");
        intent.setData(data);
        startActivity(intent);
    }
}

