package share.com.demorecylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);

        //实例化线性布局管理器
        linearLayoutManager = new LinearLayoutManager(this);

        //实例化网格布局管理器
        gridLayoutManager = new GridLayoutManager(null,4);
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);

        //实例化瀑布流布局
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);

        //设置布局管理器
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        //实例化Adapter
        adapter = new MyAdapter();

        //设置适配器
        recyclerView.setAdapter(adapter);

    }


    public void click(View vasdasd){
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager == linearLayoutManager){

            recyclerView.setLayoutManager(gridLayoutManager);

        }else if(layoutManager == gridLayoutManager){

            recyclerView.setLayoutManager(staggeredGridLayoutManager);

        }else if(layoutManager == staggeredGridLayoutManager){

                recyclerView.setLayoutManager(linearLayoutManager);

        }
    }
}
