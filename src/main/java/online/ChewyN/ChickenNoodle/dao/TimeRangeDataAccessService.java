package online.ChewyN.ChickenNoodle.dao;

import online.ChewyN.ChickenNoodle.model.TimeRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Long.getLong;

@Repository("TimeRangePostgres")
public class TimeRangeDataAccessService implements TimeRangeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TimeRangeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TimeRange insertTimeRange(TimeRange timeRange) {


        String sql = "INSERT INTO time_range(employee_id, start_time, end_time, purpose) VALUES("
                + "'" + timeRange.getEmployeeId() + "', "
                + "'" +  timeRange.getDateStart() + "', "
                + "'" +  timeRange.getDateEnd() + "', "
                + "'" +  timeRange.getPurpose() + "')"
                + "RETURNING id;";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS), keyHolder);

        return selectTimeRangeById(Objects.requireNonNull(keyHolder.getKey()).longValue()).orElse(timeRange);
    }

    @Override
    public List<TimeRange> selectAllTimeRanges() {
        String sql = "SELECT id, employee_id, start_time, end_time, purpose FROM time_range";
        return  jdbcTemplate.query(
                sql,
                (resultSet, i) -> {

                    long id = 0L;
                    try {
                        id = Long.parseLong(resultSet.getString("id"));
                    } catch (NumberFormatException ignored) { }
                    UUID employeeId = UUID.fromString(resultSet.getString("employee_id"));
                    Timestamp startTime = Timestamp.valueOf(resultSet.getString("start_time"));
                    Timestamp endTime = Timestamp.valueOf(resultSet.getString("end_time"));
                    String purpose = resultSet.getString("purpose");
                    return new TimeRange(id, employeeId, startTime, endTime, purpose);
                });
    }

    @Override
    public Optional<TimeRange> selectTimeRangeById(Long id) {
        String sql = "SELECT id, employee_id, start_time, end_time, purpose FROM time_range WHERE id = " + id + ";";
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                sql,
                (resultSet, i) -> {
                    long sqlId = 0L;
                    try {
                        sqlId = Long.parseLong(resultSet.getString("id"));
                    } catch (NumberFormatException ignored) { }
                    UUID employeeId = UUID.fromString(resultSet.getString("employee_id"));
                    Timestamp startTime = Timestamp.valueOf(resultSet.getString("start_time"));
                    Timestamp endTime = Timestamp.valueOf(resultSet.getString("end_time"));
                    String purpose = resultSet.getString("purpose");
                    return new TimeRange(sqlId, employeeId, startTime, endTime, purpose);
                })
        );
    }

    @Override
    public int deleteTimeRangeById(Long id) {
        String sql = "DELETE FROM time_range WHERE id = '" + id + "';";
        return jdbcTemplate.update(sql);
    }

    @Override
    public TimeRange updateTimeRange(Long id, TimeRange timeRange) {
        String sql = "UPDATE time_range SET "
                + "employee_id = '" +  timeRange.getEmployeeId() + "', "
                + "start_time = '" +  timeRange.getDateStart() + "', "
                + "end_time = '" +  timeRange.getDateEnd() + "', "
                + "purpose = '" +  timeRange.getPurpose() + "'"
                + " WHERE id = '" + id + "';";

        timeRange.setId(id);

        jdbcTemplate.update(sql);

        return selectTimeRangeById(id).orElse(timeRange);
    }

}