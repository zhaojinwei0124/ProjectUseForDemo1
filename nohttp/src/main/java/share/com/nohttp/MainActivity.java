package share.com.nohttp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.download.DownloadRequest;

public class MainActivity extends AppCompatActivity {

    DownloadQueue downloadQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //队列有三个任务
        downloadQueue = NoHttp.newDownloadQueue(3);
        //请求地址、请求方法、存放路径、文件名字、是否支持断点下载、是否删除以前有的文件
        DownloadRequest request = NoHttp.createDownloadRequest("url", RequestMethod.POST, Environment.getExternalStorageState().toString()+"/aa","name",true,true);
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
