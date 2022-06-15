package db.salary;

import model.User;

import java.util.ArrayList;

public interface UserTable {
    public ArrayList<User> getUsers();
    public void addUser(User user);
}
