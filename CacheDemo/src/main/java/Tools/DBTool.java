package Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/11.
 * 该工具是用来操作数据库的查询和插入功能的,而DbManger也是包含在里面，所以直接调用PublicUtils就行了
 */
public class DBTool {
    Context context;
    DbManger dbManger;
    SQLiteDatabase db;
    public DBTool(Context context) {
        this.context = context;
        dbManger = new DbManger(context, DbManger.USER_DB, null, 1);

    }

    public void insertTable(String table, ContentValues values){
        //得到数据库
        db = dbManger.getWritableDatabase();
        //insert into table(aa, bb) values ();

//        String name = values.getAsString("name");
//        String pwd = values.getAsString("pwd");
//        String icon = values.getAsString("icon");
//        db.execSQL("insert into "+ DbManger.USER_TABLE +"("+ DbManger.USER_NAME +", " + DbManger.USER_PWD + ", "+ DbManger.USER_ICON +") values (" + name +"," + pwd +"," + icon + ")");
        Log.e("------------", values.getAsString(DbManger.USER_NAME));
        db.insert(table, null, values);
    }

    public Cursor selectUser(String table){
        //得到数据库
        db = dbManger.getWritableDatabase();
        //db.execSQL("select * from user");
        Cursor cursor = db.rawQuery("select * from " + table, null);
//        if(cursor.getCount() > 0){
//            return true;
//        } else {
//            return false;
//        }
        return cursor;
    }

    public void colseDB(){
        dbManger.close();
    }
}
