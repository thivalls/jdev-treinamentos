package Application.dao;

import Application.jdbc.DbConnection;
import Application.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private Connection connection;
    private static final String TABLE = "users";

    public UserDAO() {
        this.connection = DbConnection.getConnection();
    }

    public void insert(User user) {
        try {
            String query = "insert into " + TABLE + " (id, name, email) values (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.execute();
            connection.commit();
            System.out.println("adicionado com sucesso");

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException err) {
                err.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
