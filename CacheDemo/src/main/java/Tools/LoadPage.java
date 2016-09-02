package Tools;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import data.UserInfo;

/**
 * Created by qiush on 2016/8/26.
 */
public class LoadPage extends Thread{
    String path;
    URL url;
    HttpURLConnection httpURLConnection;
    MyHandler myHandler;
    public LoadPage(String path){
        this.path=path;
        myHandler=new MyHandler();
    }
    @Override
    public void run() {
        super.run();
        try {
            url=new URL(path);
            httpURLConnection= (HttpURLConnection) url.openConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream=httpURLConnection.getInputStream();
                //读取流
                InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");  //以字节读取.
                BufferedReader br = new BufferedReader(isr);
                String line = "";
                StringBuffer sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

                Gson gson=new Gson();
                UserInfo userInfo=gson.fromJson(sb.toString(), UserInfo.class);

                Message message=myHandler.obtainMessage();
                message.obj=userInfo;
                myHandler.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    class MyHandler extends Handler{

    }

}
