package online.ChewyN.ChickenNoodle.api;

import online.ChewyN.ChickenNoodle.model.TimeRange;
import online.ChewyN.ChickenNoodle.service.TimeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/schedule")
@RestController
public class TimeRangeController {
    
    private final TimeRangeService timeRangeService;

    @Autowired
    public TimeRangeController(TimeRangeService timeRangeService) {
        this.timeRangeService = timeRangeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TimeRange>> getAllTimeRanges () {
        List<TimeRange> employees = timeRangeService.getAllTimeRanges();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<TimeRange>> getTimeRangeById (@PathVariable("id") Long id) {
        Optional<TimeRange> timeRange = timeRangeService.getTimeRangeById(id);
        return new ResponseEntity<>(timeRange, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TimeRange> AddTimeRange(@RequestBody TimeRange timeRange) {
        TimeRange newTimeRange = timeRangeService.addTimeRange(timeRange);
        return new ResponseEntity<>(newTimeRange, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TimeRange> updateTimeRange(@PathVariable("id") Long id, @RequestBody TimeRange timeRange) {
        TimeRange updateTimeRange = timeRangeService.updateTimeRange(id, timeRange);
        return new ResponseEntity<>(updateTimeRange, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateTimeRange(@PathVariable("id") Long id) {
        timeRangeService.deleteTimeRangeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
