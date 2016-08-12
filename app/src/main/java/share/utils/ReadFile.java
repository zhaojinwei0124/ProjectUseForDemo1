package share.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/7/15.
 */
public class ReadFile  {
    public static String getFileContent(Context context, String filePath){
        StringBuffer sb = new StringBuffer();
        try {
            InputStream is = context.getAssets().open(filePath);
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineStr = null;
            while((lineStr = br.readLine()) != null){
                sb.append(lineStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return sb.toString();
        }
    }
}
