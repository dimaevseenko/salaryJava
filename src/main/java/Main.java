import db.salary.SalaryDB;
import model.Salary;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Main instance;

    private Main(){}

    public void start(){
        Scanner s = new Scanner(System.in);
        User u = new User(s.next());
        SalaryDB.getInstance().getUserTable().addUser(u);
    }

    public static Main getInstance(){
        if (instance == null)
            instance = new Main();
        return instance;
    }
}
