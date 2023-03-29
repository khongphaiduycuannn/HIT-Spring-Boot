package com.example.btvn_buoi3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "admin", "1", "admin"));
        userList.add(new User(2, "ngduyminhquan", "1010", "Nguyen Duy Minh Quan"));
    }

    private static int id = 2;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Store.id = id;
    }

}
