package Application.dao;

import Application.jdbc.DbConnection;
import Application.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class UserDAO {

    private Connection connection;
    private static final String TABLE = "users";

    public UserDAO() {
        this.connection = DbConnection.getConnection();
    }

    public List<User> all() {
        try {
            String query = "select * from " + TABLE;
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            List<User> response = new ArrayList<>();

            while (result.next()) {
                response.add(
                        new User(
                                result.getString("name"),
                                result.getString("email")
                        )
                );
            }

            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public User findById(Long id) {
        try {
            User response = new User();
            String query = "select * from " + TABLE + " where id = " + id;
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                response.setId(result.getLong("id"));
                response.setName(result.getString("name"));
                response.setEmail(result.getString("email"));
            }

            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(User user) {
        try {
            // String query = "insert into " + TABLE + " (id, name, email) values (?, ?, ?)"; Alterado depois que adicionei autoincrement
            String query = "insert into " + TABLE + " (name, email) values (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.execute();
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException err) {
                err.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            String query = "update " + TABLE + " SET name = ? , email = ? where id = " + user.getId();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.execute();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException err) {
                err.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            String query = "delete from " + TABLE + " where id = " + id;
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
