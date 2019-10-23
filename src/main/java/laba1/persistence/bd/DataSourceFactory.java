package laba1.persistence.bd;


import org.apache.log4j.Logger;
import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceFactory {
    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);
    private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    private static DataSource dataSource;

    public DataSourceFactory() {
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceFactory.class.getResourceAsStream("/db.properties"));
            PGPoolingDataSource source = new PGPoolingDataSource();
            source.setServerName(properties.getProperty("DB_SERVER"));
            source.setDatabaseName(properties.getProperty("DB_NAME"));
            source.setUser(properties.getProperty("DB_USERNAME"));
            source.setPassword(properties.getProperty("DB_PASSWORD"));
            dataSource = source;
            LOG.info("DataSource created: " + dataSource);
        } catch (IOException e) {
            LOG.error("Error while reading properties from file!", e);
        }
    }

    private static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Error while connection creation", e);
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
