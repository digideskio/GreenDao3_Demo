package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class Linkman_Organization {

    private String linkmanId;
    private String organizationId;
    @Generated(hash = 540606161)
    public Linkman_Organization(String linkmanId, String organizationId) {
        this.linkmanId = linkmanId;
        this.organizationId = organizationId;
    }
    @Generated(hash = 915035201)
    public Linkman_Organization() {
    }
    public String getLinkmanId() {
        return this.linkmanId;
    }
    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
    }
    public String getOrganizationId() {
        return this.organizationId;
    }
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

}
