package com.formos.smoothie_vendor.util;

import com.formos.smoothie_vendor.error.LoginError;

import java.util.HashMap;
import java.util.Map;

public class UserUtil {

    private Map<String, String> userMap;

    private static UserUtil userUtil;

    private UserUtil() {}

    public static UserUtil getInstance() {
        if(userUtil == null) {
            userUtil = new UserUtil();
            userUtil.initUsers();
        }
        return userUtil;
    }

    public void initUsers() {
        if (userMap == null || userMap.size() == 0) {
            userMap = new HashMap<>();
            userMap.put("admin", "admin");
        }
    }

    public boolean authenticate(String user, String password) {
        if (!userMap.containsKey(user) || !password.equals(userMap.get(user)) ) {
            throw new LoginError();
        }
        return true;
    }

}
