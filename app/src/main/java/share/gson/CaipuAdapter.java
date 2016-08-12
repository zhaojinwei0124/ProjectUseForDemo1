package share.gson;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/15.
 */
public class CaipuAdapter extends BaseAdapter {
    List<GSONBean.ResultBean.DataBean> databean;
    Context context;
    public CaipuAdapter(Context  context, List<GSONBean.ResultBean.DataBean> databean){
        this.databean = databean;
        this.context = context;
    }
    @Override
    public int getCount() {
        return databean.size();
    }

    @Override
    public Object getItem(int i) {
        return databean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tv = new TextView(context);
        GSONBean.ResultBean.DataBean dataBean = databean.get(i);
        tv.setText(dataBean.title);
        return tv;
    }
}
