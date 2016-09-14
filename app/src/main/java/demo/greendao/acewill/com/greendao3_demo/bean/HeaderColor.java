package demo.greendao.acewill.com.greendao3_demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cxw on 2016/9/14.
 */
@Entity
public class HeaderColor {
    @Id
    private int colorId;

    private String colorValue;





    public String getColorValue() {
        return this.colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }

    public int getColorId() {
        return this.colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Generated(hash = 520876107)
    public HeaderColor(int colorId, String colorValue) {
        this.colorId = colorId;
        this.colorValue = colorValue;
    }

    @Generated(hash = 1905350791)
    public HeaderColor() {
    }


}
