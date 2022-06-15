package db.salary;

import jakarta.persistence.criteria.CriteriaQuery;
import model.Salary;
import org.hibernate.Session;

import java.util.ArrayList;

public class SalaryTableImpl implements SalaryTable{

    private Session session;

    public SalaryTableImpl(Session session){
        this.session = session;
    }

    @Override
    public ArrayList<Salary> geySalaries() {
        CriteriaQuery<Salary> salaries = session.getCriteriaBuilder().createQuery(Salary.class);
        salaries.from(Salary.class);
        return (ArrayList<Salary>) session.createQuery(salaries).getResultList();
    }
}
