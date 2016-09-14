package demo.greendao.acewill.com.greendao3_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alick.greendao.gen.DaoMaster;
import com.alick.greendao.gen.DaoSession;
import com.alick.greendao.gen.LinkmanDao;
import com.alick.greendao.gen.MultiChatDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import demo.greendao.acewill.com.greendao3_demo.bean.Linkman;
import demo.greendao.acewill.com.greendao3_demo.bean.Linkman_MultiChat;
import demo.greendao.acewill.com.greendao3_demo.bean.MultiChat;
import demo.greendao.acewill.com.greendao3_demo.biz.LinkmanModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

        DatabaseManager.getInstance().setupDatabase(this);
        daoSession = DatabaseManager.getInstance().getDaoSession();
//        initData();
        queryList();
    }

    private void initData() {
        saveLinkmans();
        saveMultiChats();
        saveLinkman_MultiChat();
    }

    private void queryList() {
        LinkmanModel linkmanModel=new LinkmanModel();
        List<MultiChat> multiChats = linkmanModel.queryMultiChatsByLinkmanId("cxw");
        for (MultiChat multiChat:multiChats) {
            Log.i(TAG,multiChat.getMultiChatId()+","+multiChat.getMultiChatName());
        }
    }


    private void saveLinkmans(){
        Linkman linkman1=new Linkman();
        linkman1.setLinkmanId("cxw");
        linkman1.setLinkmanName("崔兴旺");
        Linkman linkman2=new Linkman();
        linkman2.setLinkmanId("lz");
        linkman2.setLinkmanName("李正");


        daoSession.getLinkmanDao().insert(linkman1);
        daoSession.getLinkmanDao().insert(linkman2);
    }

    private void saveMultiChats() {
        MultiChat multiChat1=new MultiChat();
        multiChat1.setMultiChatId("100");
        multiChat1.setMultiChatName("android群");
        MultiChat multiChat2=new MultiChat();
        multiChat2.setMultiChatId("200");
        multiChat2.setMultiChatName("IOS群");
        daoSession.getMultiChatDao().insert(multiChat1);
        daoSession.getMultiChatDao().insert(multiChat2);
    }

    private void saveLinkman_MultiChat() {
        Linkman_MultiChat linkman_multiChat1=new Linkman_MultiChat();
        linkman_multiChat1.setLinkmanId("cxw");
        linkman_multiChat1.setMultiChatId("100");

        Linkman_MultiChat linkman_multiChat2=new Linkman_MultiChat();
        linkman_multiChat2.setLinkmanId("cxw");
        linkman_multiChat2.setMultiChatId("200");

        Linkman_MultiChat linkman_multiChat3=new Linkman_MultiChat();
        linkman_multiChat3.setLinkmanId("lz");
        linkman_multiChat3.setMultiChatId("100");

        Linkman_MultiChat linkman_multiChat4=new Linkman_MultiChat();
        linkman_multiChat4.setLinkmanId("lz");
        linkman_multiChat4.setMultiChatId("200");

        daoSession.getLinkman_MultiChatDao().insert(linkman_multiChat1);
        daoSession.getLinkman_MultiChatDao().insert(linkman_multiChat2);
        daoSession.getLinkman_MultiChatDao().insert(linkman_multiChat3);
        daoSession.getLinkman_MultiChatDao().insert(linkman_multiChat4);
    }

}
