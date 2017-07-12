package com.vagrant.android.vagrant;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by g__agee on 2017/7/11.
 */

public class Person extends BmobUser {
    private String name;
    //private String password;
    private String  phone;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
