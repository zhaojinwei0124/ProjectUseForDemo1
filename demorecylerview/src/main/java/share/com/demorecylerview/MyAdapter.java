package share.com.demorecylerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by qiush on 2016/8/20.
 */
public class MyAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyVuewHolder(View.inflate(parent.getContext(), R.layout.view_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyVuewHolder myVuewHolder = (MyVuewHolder) holder;

        myVuewHolder.tv1.setText("数据" + (position + 1));
        myVuewHolder.tv2.setText("smafsd" + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class MyVuewHolder extends RecyclerView.ViewHolder {

        private TextView tv1;
        private TextView tv2;

        public MyVuewHolder(View itemView) {
            super(itemView);

            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, (int) (Math.random() * 200 + 100));
            params.setMargins(12, 12, 12, 12);
            itemView.setLayoutParams(params);
            itemView.setBackgroundColor(Color.GRAY);


            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
        }
    }
}
