package share.com.qqlogin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView= (ImageView) findViewById(R.id.xiasi);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.xiasi);
        setImageBitmap(imageView,bitmap,this);

    }
    private static void setImageBitmap(ImageView imageView, Bitmap bitmap, Context context) {
        // Use TransitionDrawable to fade in.
        final TransitionDrawable td = new TransitionDrawable(new Drawable[]{new ColorDrawable(context.getResources().getColor(android.R.color.transparent)), new BitmapDrawable(context.getResources(), bitmap)});
        //noinspection deprecation
        imageView.setBackgroundDrawable(imageView.getDrawable());
        imageView.setImageDrawable(td);
        td.startTransition(2000);
    }
}
