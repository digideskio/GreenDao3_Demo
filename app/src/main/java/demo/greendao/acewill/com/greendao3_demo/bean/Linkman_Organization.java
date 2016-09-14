package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class Linkman_Organization {
    @Id
    private String linkman_Organization_id;

    private String linkmanId;
    private String multiChatId;
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
    public String getLinkman_Organization_id() {
        return this.linkman_Organization_id;
    }
    public void setLinkman_Organization_id(String linkman_Organization_id) {
        this.linkman_Organization_id = linkman_Organization_id;
    }
    @Generated(hash = 1217479152)
    public Linkman_Organization(String linkman_Organization_id, String linkmanId,
            String multiChatId) {
        this.linkman_Organization_id = linkman_Organization_id;
        this.linkmanId = linkmanId;
        this.multiChatId = multiChatId;
    }
    @Generated(hash = 915035201)
    public Linkman_Organization() {
    }
}
