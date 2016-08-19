package share.com.drawerlayout_demo;

import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

//Manifest文件里的application标签下的label值是用来显示到应用管理器里面的名字，而不是桌面上的图标名字。
//桌面上的图标名字是由第一个启动的activity标签下的label值来决定的，如果这个值不设置，桌面图标的名字则默认采用application标签下的label值

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView tv;
    Button btn1;
    Button btn2;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    //首先，DrawerLayout直接翻译过来就叫抽屉布局，抽屉布局分为两个部分：侧边菜单和主内容区，
    // 侧边菜单的方向是可以通过布局文件的layout_gravity属性进行设置的，本Demo还设置了ActionBarDrawerToggle，可以通过点击此开关来打开和关闭抽屉，所以逻辑上是把该开关当成监听器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv = (TextView) findViewById(R.id.tv);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
//      ActionBarDrawerToggle是抽屉布局的动画开关，R.string.open和R.string.close这两个参数是开关内部用的，代码中用不到这两个参数，内容可以随意设置，不一定是open、close
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        actionBarDrawerToggle.syncState();//该方法会自动和actionBar关联, 将开关的图片显示在了action上，如果不设置，也可以有抽屉的效果，不过是默认的图标
        drawerLayout.addDrawerListener(actionBarDrawerToggle);//给抽屉布局设置监听器，该监听器就是开关
        toolbar.setTitle("网易");//直接设置toolbar里面的title值或者在xml文件加：xmlns:app="http://schemas.android.com/apk/res-auto"和app:title="网易"两句话
//        toolbar.setLogo(R.mipmap.menu);
        setSupportActionBar(toolbar);
        //给侧边菜单的两个按钮设置监听
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("点击按钮1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("点击按钮2");
            }
        });
    }
//当ActionBarDrawerToggle被点击时返回true。
// onOptionsItemSelected是Activity里面的方法，当菜单选项被选择时调用onOptionsItemSelected，
// 然后if条件语句判断actionBarDrawerToggle.onOptionsItemSelected(item)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
