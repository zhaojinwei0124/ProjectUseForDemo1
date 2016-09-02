package Tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/11.
 */
public class DbManger extends SQLiteOpenHelper {
    public static final String USER_DB = "user_info.db";
    public static final String USER_TABLE = "user";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";
    public static final String USER_ICON = "user_icon"; //create table user (aa int, bb char);
    public static final String CREATE_USER_TABLE = "create table " + USER_TABLE + "(_id integer PRIMARY KEY autoincrement, "+ USER_NAME +" varchar(30), "+ USER_PWD +" char(30), "+ USER_ICON +" varchar(50))";
    public DbManger(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//当DbManger.getWritableDatabase()被调用时，如果数据库执行了增删改查的任意操作时，如果发现没有数据库，则会执行onCreat()方法，以后就不会被调用了
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }


//当数据库版本改动是才会被调用
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
