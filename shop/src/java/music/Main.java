package music;

import auth.Account;
import auth.AccountManager;
import database.DatabaseConnection;

import javax.naming.AuthenticationException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        try {
            connection.connect("baza.sqlite");
            //createTable(connection);
            //AccountManager accountManager = new AccountManager(connection);
            //accountManager.register("student", "haslo");
            Account.Persistence.init();
            Account.Persistence.register("student", "haslo");
            //System.out.println(accountManager.authenticate("student", "haslo"));
            Account.Persistence.authenticate("student", "haslo");
            //System.out.println(accountManager.getAccount("student"));
            connection.disconnect();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTable(DatabaseConnection connection) throws SQLException {
        String createTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL
                );
                """;

        Statement statement = connection.getConnection().createStatement();
        statement.execute(createTable);
    }

}
