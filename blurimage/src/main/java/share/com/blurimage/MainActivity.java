package share.com.blurimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import Tools.BlurTool;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img= (ImageView) findViewById(R.id.tupian);
        Bitmap bitmap=BlurTool.BoxBlurFilter(BitmapFactory.decodeResource(getResources(),R.mipmap.logoo ));
        img.setImageBitmap(bitmap);
    }
}
