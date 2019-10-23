package laba1.persistence.dao;

import laba1.persistence.bd.DataSourceFactory;
import laba1.persistence.entity.CoachType;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCoachDao {
    private static final Logger LOG = Logger.getLogger(TypeCoachDao.class);
    private static final String READ = "SELECT * FROM type_passaneger_coach";
    private static final String CREATE = "INSERT INTO type_passaneger_coach (id , capacity, type, luggage_weight) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE type_passaneger_coach SET id = ?, capacity = ?, type = ?, luggage_weight = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM type_passaneger_coach WHERE id = ?";


    public List<CoachType> read () {
        List<CoachType> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(READ);
             ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int capacity = resultSet.getInt("capacity");
                    String type = resultSet.getString("type");
                    int luggageWeight = resultSet.getInt("luggage_weight");
                    result.add(new CoachType(id, capacity, type, luggageWeight));
                    LOG.info("Read procedure done success");
                }
        } catch (SQLException e) {
            LOG.error("Read procedure failed", e);
        }

        return result;
    }

    public int create (CoachType coachType) {

       int id = coachType.getId();
       int capacity = coachType.getCapacity();
       String type = coachType.getType();
       int luggageWeight = coachType.getLuggage();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(CREATE);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,capacity);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, luggageWeight);
            int result = preparedStatement.executeUpdate();
            LOG.info("Create procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("Create procedure failed", e);
            return -1;
        }
    }
    public int update (CoachType coachType) {

        int id = coachType.getId();
        int capacity = coachType.getCapacity();
        String type = coachType.getType();
        int luggageWeight = coachType.getLuggage();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(UPDATE);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,capacity);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, luggageWeight);
            preparedStatement.setInt(5,id);

            int result = preparedStatement.executeUpdate();
            LOG.info("UPDATE procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("UPDATE procedure failed", e);
            return -1;
        }
    }

    public int delete (int id) {

        int idWhere = id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataSourceFactory.getPreparedStatement(DELETE);
            preparedStatement.setInt(1,idWhere);
            int result = preparedStatement.executeUpdate();
            LOG.info("DELETE procedure done success");
            return result;
        } catch (SQLException e) {
            LOG.error("DELETE procedure failed", e);
            return -1;
        }
    }

}
