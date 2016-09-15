package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class Linkman_MultiChat {
    private String linkmanId;
    private String multiChatId;


    @Generated(hash = 1616652049)
    public Linkman_MultiChat(String linkmanId, String multiChatId) {
        this.linkmanId = linkmanId;
        this.multiChatId = multiChatId;
    }
    @Generated(hash = 902393231)
    public Linkman_MultiChat() {
    }
    public String getMultiChatId() {
        return this.multiChatId;
    }
    public void setMultiChatId(String multiChatId) {
        this.multiChatId = multiChatId;
    }
    public String getLinkmanId() {
        return this.linkmanId;
    }
    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
    }

}
