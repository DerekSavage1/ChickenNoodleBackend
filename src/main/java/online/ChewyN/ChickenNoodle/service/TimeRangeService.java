package online.ChewyN.ChickenNoodle.service;

import online.ChewyN.ChickenNoodle.dao.TimeRangeDao;
import online.ChewyN.ChickenNoodle.model.TimeRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeRangeService {


    private final TimeRangeDao timeRangeDao;

    @Autowired
    public TimeRangeService(@Qualifier("TimeRangePostgres") TimeRangeDao timeRangeDao) {
        this.timeRangeDao = timeRangeDao;
    }

    public TimeRange addTimeRange(TimeRange timeRange) {
        return timeRangeDao.insertTimeRange(timeRange);
    }

    public List<TimeRange> getAllTimeRanges() {
        return timeRangeDao.selectAllTimeRanges();
    }

    public Optional<TimeRange> getTimeRangeById(Long id) {
        return timeRangeDao.selectTimeRangeById(id);
    }

    public int deleteTimeRangeById(Long id) {
        return timeRangeDao.deleteTimeRangeById(id);
    }

    public TimeRange updateTimeRange(Long id, TimeRange timeRange) {
        timeRangeDao.updateTimeRange(id, timeRange);
        return timeRange;
    }



}
