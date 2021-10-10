package Application.dao;

import Application.jdbc.DbConnection;
import Application.models.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneDAO {
    private Connection connection;
    private static final String TABLE = "phones";

    public PhoneDAO() {
        this.connection = DbConnection.getConnection();
    }

    public void insert(Phone phone) {
        try {
            String sql = "insert into " + TABLE + " (user_id, type, number) values (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, phone.getUser_id());
            stmt.setString(2, phone.getType());
            stmt.setString(3, phone.getNumber());
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
}
