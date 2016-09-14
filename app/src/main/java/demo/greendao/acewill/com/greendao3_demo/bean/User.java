package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class User {
    @Id
    private int id;

    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Generated(hash = 996641494)
    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
