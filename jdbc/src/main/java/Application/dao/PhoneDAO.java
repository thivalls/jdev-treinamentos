package Application.dao;

import Application.jdbc.DbConnection;
import Application.models.Phone;
import Application.models.PhoneResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<PhoneResponse> getPhones(Long user_id) {
        List<PhoneResponse> response = new ArrayList<>();
        try {
            String sql = "select name, number, type from " + TABLE + " as p INNER JOIN users as u on p.user_id = u.id WHERE u.id = " + user_id;
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                response.add(new PhoneResponse(result.getString("name"), result.getString("number"), result.getString("type")));
            }

            return response;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException err) {
                err.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}
