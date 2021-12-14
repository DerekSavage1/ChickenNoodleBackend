package online.ChewyN.ChickenNoodle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class TimeRange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private UUID employeeId;


    private Timestamp dateStart;
    private Timestamp dateEnd;

    private String purpose;

    public TimeRange(
            @JsonProperty("id") Long id,
            @JsonProperty("employeeId") UUID employeeId,
            @JsonProperty("dateStart") Timestamp dateStart,
            @JsonProperty("dateEnd") Timestamp dateEnd,
            @JsonProperty("purpose") String purpose) {
        this.id = id;
        this.employeeId = employeeId;

        if(dateStart.before(dateEnd))
        {
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
        }
        else {
            this.dateStart = dateEnd;
            this.dateEnd = dateStart;
        }

        this.purpose = purpose;
        System.out.println(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", flag='" + purpose + '\'' +
                '}';
    }
}

