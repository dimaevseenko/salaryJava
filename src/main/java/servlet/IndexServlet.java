package servlet;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import db.salary.SalaryDB;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Salary;
import model.User;
import responce.SalaryDBResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();

        if(req.getParameter("action") != null)
            if(req.getParameter("action").equals("addUser"))
                if(req.getParameter("data") != null){
                    User user = new Gson().fromJson(req.getParameter("data"), User.class);
                    addUser(user);
                }

        printSalaryDB(printWriter);

        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();

        printSalaryDB(printWriter);

        printWriter.close();
    }

    private void addUser(User user){
        SalaryDB.getInstance().getUserTable().addUser(user);
    }

    private void printSalaryDB(PrintWriter printWriter){
        ArrayList<User> users = SalaryDB.getInstance().getUserTable().getUsers();
        ArrayList<Salary> salaries = SalaryDB.getInstance().getSalaryTable().geySalaries();

        printWriter.write(new Gson().toJson(
                new SalaryDBResponse(users, salaries)
        ));
    }
}
