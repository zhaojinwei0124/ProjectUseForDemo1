package Tools;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/8/11.
 * 此文件作用是把网上获得的图片写进SD卡缓存
 */
public class SdcardUtils {
    public static final String cashFolder = "user_info";
    //判断SD卡状态，当调用getExternalStorage()时，如果存在内存卡就返回mounted字符串
    public static boolean exiteSDcard(){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return true;
        } else {
            return false;
        }
    }
    //此方法的输入参数是图片的网址，输出参数是图片缓存在ＳＤ卡的路径，路径是自己去指定拼接，str.split("/")是把网址的/分离出来放在字符串数组中，通过数组找到最后一个字符串目的是为了得到这张图片的名字，File.separator是文件分隔符，在不同操作系统分隔符会变化
    // 最终拼接的地址为：SD卡根路径/user_info/图片名（head.png）
    public static String getStr(String str){
        String[] array = str.split("/");
        String s = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + cashFolder + File.separator +  array[array.length - 1];
        return s;
    }
    //通过网址得到图片名字
    public static String getFileName(String str){
        String[] array = str.split("/");
        String s = array[array.length - 1];
        return s;
    }

    //Bitmap转换成byte[]
    public static byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
    //向拼接出来的SD卡路径写入图片，第一个参数是路径，第二个参数是图片
    public static void writeCashSD(String name, Bitmap bitmap){
        if(exiteSDcard()){
            String root = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(root + File.separator + cashFolder);
            if(!file.exists()){
                file.mkdir();
            }
            try {
//                File f = new File(file, name);
//                FileOutputStream fos = new FileOutputStream(f);
//                fos.write(Bitmap2Bytes(bitmap));

                FileOutputStream fos = new FileOutputStream(new File(file, name));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
