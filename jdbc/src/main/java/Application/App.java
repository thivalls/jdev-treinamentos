package Application;

import Application.dao.UserDAO;
import Application.jdbc.DbConnection;
import Application.models.User;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        System.out.println("criando minha primeira conexão JDBC");
        User user = new User(3L, "Julio", "julio@cesar.com.br");
        UserDAO userDAO = new UserDAO();
        userDAO.insert(user);
    }
}
