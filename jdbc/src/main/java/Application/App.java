package Application;

import Application.dao.PhoneDAO;
import Application.dao.UserDAO;
import Application.jdbc.DbConnection;
import Application.models.Phone;
import Application.models.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Trabalhando com JDBC");

//        System.out.println("INSERT");
//        User user = new User("Roger", "roger@guedes.com.br");
//        UserDAO userDAO = new UserDAO();
//        userDAO.insert(user);

        System.out.println("INSERT IN PHONE TABLE");
        Phone phone = new Phone(5L, "cellphone", "111222333");
        PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.insert(phone);


//        System.out.println("Buscando todos registros");
//        UserDAO userDAO = new UserDAO();
//        List<User> users = new ArrayList<>();
//        users = userDAO.all();
//
//        for (User user : users) {
//            System.out.println(user.getName());
//        }

//        System.out.println("Buscando registro por id");
//        UserDAO userDAO = new UserDAO();
//        User user = userDAO.findById(4L);
//        System.out.println(user.getName());

//        System.out.println("Atualizando registro");
//        UserDAO userDAO = new UserDAO();
//        User user = userDAO.findById(4L);
//        System.out.println("nome antes da atualizacao => " + user.getName());
//        System.out.println("Atualizando....");
//        user.setName("joanão");
//        user.setEmail("joan@nao.com.br");
//        userDAO.update(user);
//
//        user = userDAO.findById(4L);
//        System.out.println("Novo nome => " + user.getName());

//        System.out.println("Deletando registro");
//        List<User> users = new ArrayList<>();
//        UserDAO userDAO = new UserDAO();
//        users = userDAO.all();
//        System.out.println("Listagem antes da exclusão");
//        for (User user : users) {
//            System.out.println(user.getName());
//        }
//
//        userDAO.delete(1L);
//
//
//        users = userDAO.all();
//        System.out.println("Listagem depois da exclusão");
//        for (User user : users) {
//            System.out.println(user.getName());
//        }
    }
}
