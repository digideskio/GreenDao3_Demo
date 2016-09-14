package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.alick.greendao.gen.DaoSession;
import com.alick.greendao.gen.MultiChatDao;
import com.alick.greendao.gen.LinkmanDao;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class MultiChat {
	@Id
	private String multiChatId;
	private String multiChatName;

	@ToMany(referencedJoinProperty = "linkmanId")
	private List<Linkman> linkmens;
	/** Used for active entity operations. */
	@Generated(hash = 2062924800)
	private transient MultiChatDao myDao;
	/** Used to resolve relations */
	@Generated(hash = 2040040024)
	private transient DaoSession daoSession;


	public String getMultiChatId() {
		return this.multiChatId;
	}

	public void setMultiChatId(String multiChatId) {
		this.multiChatId = multiChatId;
	}

	public String getMultiChatName() {
		return this.multiChatName;
	}

	public void setMultiChatName(String multiChatName) {
		this.multiChatName = multiChatName;
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

	/** Resets a to-many relationship, making the next get call to query for a fresh result. */
	@Generated(hash = 1569884840)
	public synchronized void resetLinkmens() {
		linkmens = null;
	}

	/**
	 * To-many relationship, resolved on first access (and after reset).
	 * Changes to to-many relations are not persisted, make changes to the target entity.
	 */
	@Generated(hash = 1631123566)
	public List<Linkman> getLinkmens() {
	    if (linkmens == null) {
	        final DaoSession daoSession = this.daoSession;
	        if (daoSession == null) {
	            throw new DaoException("Entity is detached from DAO context");
	        }
	        LinkmanDao targetDao = daoSession.getLinkmanDao();
	        List<Linkman> linkmensNew = targetDao._queryMultiChat_Linkmens(multiChatId);
	        synchronized (this) {
	            if(linkmens == null) {
	                linkmens = linkmensNew;
	            }
	        }
	    }
	    return linkmens;
	}

	/** called by internal mechanisms, do not call yourself. */
	@Generated(hash = 990857677)
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getMultiChatDao() : null;
	}

	@Generated(hash = 1857389515)
	public MultiChat(String multiChatId, String multiChatName) {
		this.multiChatId = multiChatId;
		this.multiChatName = multiChatName;
	}

	@Generated(hash = 2082361316)
	public MultiChat() {
	}




}
