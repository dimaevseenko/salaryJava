package responce;

import com.google.gson.annotations.SerializedName;
import model.Salary;
import model.User;

import java.util.ArrayList;

public class SalaryDBResponse{
    @SerializedName("users")
    private ArrayList<User> userArray;

    @SerializedName("salaries")
    private ArrayList<Salary> salaryList;

    public SalaryDBResponse(ArrayList<User> userArray, ArrayList<Salary> salaryList) {
        this.userArray = userArray;
        this.salaryList = salaryList;
    }
}