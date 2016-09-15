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
import demo.greendao.acewill.com.greendao3_demo.bean.Linkman_Organization;
import demo.greendao.acewill.com.greendao3_demo.bean.MultiChat;
import demo.greendao.acewill.com.greendao3_demo.bean.Organization;
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
//        queryList();
        queryOrganizationList();

//        insertData();
    }

    private void insertData() {
        Linkman linkman=new Linkman();
        linkman.setLinkmanId("zhangsan");
        linkman.setLinkmanName("张三");
        DatabaseManager.getInstance().getDaoSession().getLinkmanDao().insert(linkman);

        Organization organization=new Organization();
        organization.setOrganizationId("3000");
        organization.setOrganizationName("研发部");
        DatabaseManager.getInstance().getDaoSession().getOrganizationDao().insert(organization);
    }

    private void queryOrganizationList() {
        Linkman linkman = DatabaseManager.getInstance().getDaoSession().getLinkmanDao().load("cxw");
        List<Organization> organizations = linkman.getOrganizations();
        for (Organization organization:organizations) {
            List<Linkman> linkmans = organization.getLinkmans();
            Log.i(TAG,organization.getOrganizationName()+"包含以下成员:");
            for (Linkman linkman1:linkmans) {
                Log.i(TAG,linkman1.getLinkmanName());
            }
            Log.i(TAG,"---------------");
        }
    }

    private void initData() {
        saveLinkmans();
        saveMultiChats();
        saveOrganizations();
        saveLinkman_MultiChat();
        saveLinkman_Organization();
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

    private void saveOrganizations() {
        Organization organization1=new Organization();
        organization1.setOrganizationId("1000");
        organization1.setOrganizationName("财务部");
        Organization organization2=new Organization();
        organization2.setOrganizationId("2000");
        organization2.setOrganizationName("行政部");
        daoSession.getOrganizationDao().insert(organization1);
        daoSession.getOrganizationDao().insert(organization2);
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

    private void saveLinkman_Organization() {
        Linkman_Organization linkman_organization1=new Linkman_Organization();
        linkman_organization1.setLinkmanId("cxw");
        linkman_organization1.setOrganizationId("1000");

        Linkman_Organization linkman_organization2=new Linkman_Organization();
        linkman_organization2.setLinkmanId("cxw");
        linkman_organization2.setOrganizationId("2000");

        Linkman_Organization linkman_organization3=new Linkman_Organization();
        linkman_organization3.setLinkmanId("lz");
        linkman_organization3.setOrganizationId("1000");

        Linkman_Organization linkman_organization4=new Linkman_Organization();
        linkman_organization4.setLinkmanId("lz");
        linkman_organization4.setOrganizationId("2000");

        daoSession.getLinkman_OrganizationDao().insert(linkman_organization1);
        daoSession.getLinkman_OrganizationDao().insert(linkman_organization2);
        daoSession.getLinkman_OrganizationDao().insert(linkman_organization3);
        daoSession.getLinkman_OrganizationDao().insert(linkman_organization4);

    }

}
