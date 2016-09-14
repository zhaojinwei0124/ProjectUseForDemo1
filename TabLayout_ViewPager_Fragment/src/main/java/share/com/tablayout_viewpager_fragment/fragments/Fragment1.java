package share.com.tablayout_viewpager_fragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import share.com.tablayout_viewpager_fragment.R;

/**
 * Created by qiush on 2016/9/12.
 */
public class Fragment1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,null,false);
        //TextView textView= (TextView) view.findViewById(R.id.txt);

        return view;
    }
}
