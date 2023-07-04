package DesignPatterns.inventorymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    private final List<User> users;
    private final Map<Integer, User> userIdVsObjectMap;

    public UserController() {
        users = new ArrayList<>();
        userIdVsObjectMap = new HashMap<>();
    }

    public void addUser(User user) {
        users.add(user);
        userIdVsObjectMap.put(user.getUserId(), user);
    }

    public void removeUser(User user) {
        users.remove(user);
        userIdVsObjectMap.remove(user.getUserId());
    }
}
