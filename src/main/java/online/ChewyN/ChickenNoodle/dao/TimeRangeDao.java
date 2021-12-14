package online.ChewyN.ChickenNoodle.dao;

import online.ChewyN.ChickenNoodle.model.TimeRange;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TimeRangeDao {

    TimeRange insertTimeRange(TimeRange timeRange);

    List<TimeRange> selectAllTimeRanges();

    Optional<TimeRange> selectTimeRangeById(Long id);

    int deleteTimeRangeById(Long id);

    TimeRange updateTimeRange(Long id, TimeRange timeRange);

}
