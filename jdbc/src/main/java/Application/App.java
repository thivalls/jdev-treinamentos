package Application;

import Application.dao.UserDAO;
import Application.jdbc.DbConnection;
import Application.models.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Trabalhando com JDBC");

//        System.out.println("INSERT");
//        User user = new User(3L, "Julio", "julio@cesar.com.br");
//        UserDAO userDAO = new UserDAO();
//        userDAO.insert(user);


        System.out.println("Buscando todos registros");
        UserDAO userDAO = new UserDAO();
        List<User> users = new ArrayList<>();
        users = userDAO.all();

        for (User user : users) {
            System.out.println(user.getName());
        }

    }
}
