package demo.greendao.acewill.com.greendao3_demo.biz;

import com.alick.greendao.gen.DaoSession;
import com.alick.greendao.gen.MultiChatDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import demo.greendao.acewill.com.greendao3_demo.DatabaseManager;
import demo.greendao.acewill.com.greendao3_demo.bean.Linkman;
import demo.greendao.acewill.com.greendao3_demo.bean.Linkman_MultiChat;
import demo.greendao.acewill.com.greendao3_demo.bean.MultiChat;

/**
 * Created by cxw on 2016/9/14.
 */
public class LinkmanModel {
    public List<MultiChat> queryMultiChatsByLinkmanId(String linkmanId) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        //查询id为cxw的联系人在哪些群中
        Linkman linkman = daoSession.getLinkmanDao().load(linkmanId);
        if(linkman==null){
            return null;
        }
        return linkman.getMultiChats();
    }


}
