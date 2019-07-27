package db;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class BaseManager {
    public static final String JDBC_SQLITE_DATABASE = "jdbc:sqlite:database.db";
    private static ConnectionSource connectionSource;

    public static void makeConnection() throws SQLException {
         connectionSource = new JdbcConnectionSource(JDBC_SQLITE_DATABASE);
    }

    public static ConnectionSource getConnection(){
        return connectionSource;
    }
    public static void createDB(ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, FormDbModel.class);
    }
    public static void closeConnection() throws IOException {
        connectionSource.close();
    }
    public static void createDBTable() throws SQLException, IOException {
        makeConnection();
     //   TableUtils.dropTable(connectionSource, FormDbModel.class,true);
        createDB(getConnection());
        closeConnection();
    }
}
