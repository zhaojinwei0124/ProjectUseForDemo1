package share.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import share.utils.ReadFile;

public class MainActivity extends AppCompatActivity {
    /**把模拟的JSON数据转换为对象，并显示在界面上的步骤：
      第一步：模拟数据，把第三方的JSON数据，得到自己项目中
              在项目下建立assets目录，并在assets目录下，建立文本文件，把第三方的JSON数据复制到文件文件中。

      第二步：建立与JSON相对应的类。

      第三步：读取第一步中建立的文本文件内容， InputStream is = context.getAssets().open(fileName);

      第四步: 把读取出来的字符串内容，转换为GSON对象。
              a、创建GSON对象   Gson datas = new Gson();
              b、把字符串转换为 GSONBean对象  GSONBean bean = datas.fromJson(resource, GSONBean.class);

      第五步:操作已经有数据的GSONBean对象
     */

    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.caipus);

        String resource = ReadFile.getFileContent(this, "aa.txt");

        //创建GSON对象
        Gson datas = new Gson();

        //把字符串中的值，赋给GSONBean对象
        //实例化GSONBean对象，并给他的变量赋值
        GSONBean bean = datas.fromJson(resource, GSONBean.class);

        String code = bean.resultcode;
        Log.e("返回码", code);


        List<GSONBean.ResultBean.DataBean> databean = bean.result.data;

        listView.setAdapter(new CaipuAdapter(this, databean));
        /*for(int i=0; i<databean.size(); i++){
            GSONBean.ResultBean.DataBean dataItem = databean.get(i);
            String title = dataItem.title;
            String id = dataItem.id;
            List<String> albuls = dataItem.albums;
            Log.e("结果", id + "\t" + title + albuls.get(0));
        }*/
    }
}
