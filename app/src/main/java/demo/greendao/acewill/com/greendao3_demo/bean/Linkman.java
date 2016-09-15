package demo.greendao.acewill.com.greendao3_demo.bean;


import com.alick.greendao.gen.DaoSession;
import com.alick.greendao.gen.HeaderColorDao;
import com.alick.greendao.gen.LinkmanDao;
import com.alick.greendao.gen.Linkman_MultiChatDao;
import com.alick.greendao.gen.OrganizationDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import com.alick.greendao.gen.MultiChatDao;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class Linkman {
    @Id
    @Unique
    private String linkmanId;
    private String linkmanName;
    private int linkman_head_color;
    private boolean isManager;

    private int colorId;

    @ToOne(joinProperty = "colorId")
    private HeaderColor headerColor;

    @ToMany
    @JoinEntity(entity = Linkman_MultiChat.class,sourceProperty = "linkmanId",targetProperty = "multiChatId")
    private List<MultiChat> multiChats;

    @ToMany
    @JoinEntity(entity = Linkman_Organization.class,sourceProperty = "linkmanId",targetProperty = "organizationId")
    private List<Organization> organizations;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 732760886)
    private transient LinkmanDao myDao;

    @Generated(hash = 1597881201)
    public Linkman(String linkmanId, String linkmanName, int linkman_head_color, boolean isManager, int colorId) {
        this.linkmanId = linkmanId;
        this.linkmanName = linkmanName;
        this.linkman_head_color = linkman_head_color;
        this.isManager = isManager;
        this.colorId = colorId;
    }

    @Generated(hash = 1636986190)
    public Linkman() {
    }

    public String getLinkmanId() {
        return this.linkmanId;
    }

    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
    }

    public String getLinkmanName() {
        return this.linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public int getLinkman_head_color() {
        return this.linkman_head_color;
    }

    public void setLinkman_head_color(int linkman_head_color) {
        this.linkman_head_color = linkman_head_color;
    }

    public boolean getIsManager() {
        return this.isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public int getColorId() {
        return this.colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Generated(hash = 858566474)
    private transient Integer headerColor__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 375851529)
    public HeaderColor getHeaderColor() {
        int __key = this.colorId;
        if (headerColor__resolvedKey == null || !headerColor__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HeaderColorDao targetDao = daoSession.getHeaderColorDao();
            HeaderColor headerColorNew = targetDao.load(__key);
            synchronized (this) {
                headerColor = headerColorNew;
                headerColor__resolvedKey = __key;
            }
        }
        return headerColor;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 765434129)
    public void setHeaderColor(@NotNull HeaderColor headerColor) {
        if (headerColor == null) {
            throw new DaoException("To-one property 'colorId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.headerColor = headerColor;
            colorId = headerColor.getColorId();
            headerColor__resolvedKey = colorId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 721513479)
    public List<MultiChat> getMultiChats() {
        if (multiChats == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MultiChatDao targetDao = daoSession.getMultiChatDao();
            List<MultiChat> multiChatsNew = targetDao._queryLinkman_MultiChats(linkmanId);
            synchronized (this) {
                if(multiChats == null) {
                    multiChats = multiChatsNew;
                }
            }
        }
        return multiChats;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 593069290)
    public synchronized void resetMultiChats() {
        multiChats = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1680671657)
    public List<Organization> getOrganizations() {
        if (organizations == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrganizationDao targetDao = daoSession.getOrganizationDao();
            List<Organization> organizationsNew = targetDao._queryLinkman_Organizations(linkmanId);
            synchronized (this) {
                if(organizations == null) {
                    organizations = organizationsNew;
                }
            }
        }
        return organizations;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 88713448)
    public synchronized void resetOrganizations() {
        organizations = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 648260577)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLinkmanDao() : null;
    }




}
