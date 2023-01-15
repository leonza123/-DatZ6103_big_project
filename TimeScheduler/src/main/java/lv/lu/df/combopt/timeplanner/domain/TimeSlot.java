package lv.lu.df.combopt.timeplanner.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idk", scope = TimeSlot.class)
public class TimeSlot {
    private Integer idk;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;

    public TimeSlot() {}

    public TimeSlot(LocalTime startTime, LocalTime endTime, LocalDate date)
    {
        setStartTime(startTime);
        setEndTime(endTime);
        setDate(date);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

     public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getIdk() {
        return idk;
    }

    public void setIdk(Integer idk) {
        this.idk = idk;
    }
}
