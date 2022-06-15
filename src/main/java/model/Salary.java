package model;

import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.Star;

@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "post")
    private String post;

    @Column(name = "salary")
    private Double salary;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return user.getName()+" "+post+" "+salary;
    }
}
