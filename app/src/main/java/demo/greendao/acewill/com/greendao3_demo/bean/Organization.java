package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.alick.greendao.gen.DaoSession;
import com.alick.greendao.gen.LinkmanDao;
import com.alick.greendao.gen.OrganizationDao;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class Organization {
    @Id
    private String organizationId;

    private String organizationName;

    @ToMany
    @JoinEntity(entity = Linkman_Organization.class,sourceProperty = "organizationId",targetProperty = "linkmanId")
    private List<Linkman> linkmans;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 49964946)
    private transient OrganizationDao myDao;

    @Generated(hash = 1450227593)
    public Organization(String organizationId, String organizationName) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
    }

    @Generated(hash = 27039612)
    public Organization() {
    }

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 767213373)
    public List<Linkman> getLinkmans() {
        if (linkmans == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LinkmanDao targetDao = daoSession.getLinkmanDao();
            List<Linkman> linkmansNew = targetDao._queryOrganization_Linkmans(organizationId);
            synchronized (this) {
                if(linkmans == null) {
                    linkmans = linkmansNew;
                }
            }
        }
        return linkmans;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 719727550)
    public synchronized void resetLinkmans() {
        linkmans = null;
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
    @Generated(hash = 1328120336)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrganizationDao() : null;
    }

    
}
