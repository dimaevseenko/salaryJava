package db.salary;

import model.User;
import org.hibernate.Session;

public class SalaryDB {

    private static SalaryDB instance;

    private SalaryDB(){}

    private Session getSession(){
        return SalaryDBSessionFactory.getSalaryDBSession().openSession();
    }

    public UserTable getUserTable(){
        return new UserTableImpl(getSession());
    }

    public SalaryTable getSalaryTable(){
        return new SalaryTableImpl(getSession());
    }

    public static SalaryDB getInstance(){
        if (instance == null)
            instance = new SalaryDB();
        return instance;
    }
}
