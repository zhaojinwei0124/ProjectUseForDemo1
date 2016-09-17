package share.com.nohttp;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.download.DownloadRequest;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    DownloadQueue downloadQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //队列有三个任务
        downloadQueue = NoHttp.newDownloadQueue(3);
        //请求地址、请求方法、存放路径、文件名字、是否支持断点下载、是否删除以前有的文件，这里不能用POST方法好像是百度服务器限制
        final DownloadRequest request = NoHttp.createDownloadRequest("http://gdown.baidu.com/data/wisegame/4f45d1baacb6ee7f/baidushoujizhushouyuan91zhu_16789458.apk", RequestMethod.POST, Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + "NoHttpSample","nohttp.apk",true,true);
        //给这个请求加了一个what值"1"，在把请求加到队列中，再实现监听
        downloadQueue.add(1, request, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {

            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {

            }

            @Override
            public void onProgress(int what, int progress, long fileCount) {

            }

            @Override
            public void onFinish(int what, String filePath) {

            }

            @Override
            public void onCancel(int what) {

            }
        });
    }
}
