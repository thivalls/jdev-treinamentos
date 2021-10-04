package Application.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DbConnectionTest {

    @Test
    public void shouldConnectWithDatabaseWithCorrectCredentials() {
        DbConnection.getConnection();
    }

}