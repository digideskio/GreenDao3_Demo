package demo.greendao.acewill.com.greendao3_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.alick.greendao.gen.DaoMaster;
import com.alick.greendao.gen.DaoSession;

import org.greenrobot.greendao.identityscope.IdentityScopeType;

/**
 * Created by cxw on 2016/7/18.
 */
public class DatabaseManager {
    private static final String DB_NAME = "greenDaoDemo.db";
    private static DatabaseManager databaseManager;
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;

    private DatabaseManager(){

    }

    public static DatabaseManager getInstance(){
        if(databaseManager==null){
            synchronized (DatabaseManager.class){
                if(databaseManager==null){
                    databaseManager=new DatabaseManager();
                }
            }
        }
        return databaseManager;
    }


    public void setupDatabase(Context context) {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(context,DB_NAME, null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        //IdentityScopeType.None代表不缓存,防止查询的结果与数据库的数据不符
        daoSession = daoMaster.newSession(IdentityScopeType.None);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }



}
