package lv.lu.df.combopt.timeplanner.testData;
import lv.lu.df.combopt.timeplanner.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class problem0 {
    public static AimSchedule generateData1() {
        var per1 = new Person("Andy D.");
        var per2 = new Person("Evan C.");
        var per3 = new Person("Anna V.");
        List<Person> persons = List.of(per1, per2, per3);

        var dt1 = LocalDate.of(2022, 12, 1);

        var ts1 = new TimeSlot(LocalTime.of(9,0), LocalTime.of(9, 30), dt1);
        var ts2 = new TimeSlot(LocalTime.of(9,30), LocalTime.of(10, 00), dt1);
        var ts3 = new TimeSlot(LocalTime.of(10,00), LocalTime.of(10, 30), dt1);
        var ts4 = new TimeSlot(LocalTime.of(10,30), LocalTime.of(11, 00), dt1);
        List<TimeSlot> timeSlots = List.of(ts1, ts2, ts3, ts4);

        var act1 = new Activity("Activity1", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 20), dt1));
        var act2 = new Activity("Activity2", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 25), dt1));
        var act3 = new Activity("Activity3", new TimeSlot(LocalTime.of(10, 10), LocalTime.of(10, 55), dt1));
        var act4 = new Activity("Activity4", new TimeSlot(LocalTime.of(10, 20), LocalTime.of(10, 50), dt1));
        List<Activity> activities = new LinkedList<>();
        activities.add(act1);
        activities.add(act2);
        activities.add(act3);
        activities.add(act4);

        List<Aim> aims = new LinkedList<>();
        aims.add(new Aim(null, per1, ts1, "aim1"));
        aims.add(new Aim(null, per1, ts2, "aim2"));
        aims.add(new Aim(null, per1, ts3, "aim3"));
        aims.add(new Aim(null, per1, ts4, "aim4"));
        aims.add(new Aim(null, per2, ts1, "aim5"));
        aims.add(new Aim(null, per2, ts2, "aim6"));
        aims.add(new Aim(null, per2, ts3, "aim7"));
        aims.add(new Aim(null, per2, ts4, "aim8"));
        aims.add(new Aim(null, per3, ts1, "aim9"));
        aims.add(new Aim(null, per3, ts2, "aim10"));
        aims.add(new Aim(null, per3, ts3, "aim11"));
        aims.add(new Aim(null, per3, ts4, "aim12"));

        AimSchedule schedule = new AimSchedule();
        schedule.setPersons(persons);
        schedule.setTimeSlots(timeSlots);
        schedule.setActivities(activities);
        schedule.setAims(aims);

        return schedule;
    }

    public static AimSchedule generateData2() {
        var per1 = new Person("Andy D.");
        var per2 = new Person("Evan C.");
        List<Person> persons = List.of(per1, per2);

        var dt1 = LocalDate.of(2022, 12, 1);
        var dt2 = LocalDate.of(2022, 12, 2);

        var ts1 = new TimeSlot(LocalTime.of(9,0), LocalTime.of(9, 30), dt1);
        var ts2 = new TimeSlot(LocalTime.of(9,30), LocalTime.of(10, 00), dt1);
        var ts3 = new TimeSlot(LocalTime.of(10,00), LocalTime.of(10, 30), dt1);
        var ts4 = new TimeSlot(LocalTime.of(10,30), LocalTime.of(11, 00), dt1);
        var ts1_1 = new TimeSlot(LocalTime.of(9,0), LocalTime.of(9, 30), dt2);
        var ts2_2 = new TimeSlot(LocalTime.of(9,30), LocalTime.of(10, 00), dt2);
        var ts3_3 = new TimeSlot(LocalTime.of(10,00), LocalTime.of(10, 30), dt2);
        var ts4_4 = new TimeSlot(LocalTime.of(10,30), LocalTime.of(11, 00), dt2);
        List<TimeSlot> timeSlots = List.of(ts1, ts2, ts3, ts4, ts1_1, ts2_2, ts3_3, ts4_4);

        var act1 = new Activity("Activity1", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 20), dt1));
        var act2 = new Activity("Activity2", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 25), dt1));
        var act3 = new Activity("Activity3", new TimeSlot(LocalTime.of(10, 10), LocalTime.of(10, 55), dt1));
        var act4 = new Activity("Activity4", new TimeSlot(LocalTime.of(10, 20), LocalTime.of(10, 50), dt1));
        var act5 = new Activity("Activity5", new TimeSlot(LocalTime.of(10, 20), LocalTime.of(10, 50), dt2));
        var act6 = new Activity("Activity6", new TimeSlot(LocalTime.of(9, 05), LocalTime.of(10, 50), dt2));
        List<Activity> activities = new LinkedList<>();
        activities.add(act1);
        activities.add(act2);
        activities.add(act3);
        activities.add(act4);
        activities.add(act5);
        activities.add(act6);

        List<Aim> aims = new LinkedList<>();
        aims.add(new Aim(null, per1, ts1, "aim1"));
        aims.add(new Aim(null, per1, ts2, "aim2"));
        aims.add(new Aim(null, per1, ts3, "aim3"));
        aims.add(new Aim(null, per1, ts4, "aim4"));
        aims.add(new Aim(null, per2, ts1, "aim5"));
        aims.add(new Aim(null, per2, ts2, "aim6"));
        aims.add(new Aim(null, per2, ts3, "aim7"));
        aims.add(new Aim(null, per2, ts4, "aim8"));
        aims.add(new Aim(null, per1, ts1_1, "aim9"));
        aims.add(new Aim(null, per1, ts2_2, "aim10"));
        aims.add(new Aim(null, per1, ts3_3, "aim11"));
        aims.add(new Aim(null, per1, ts4_4, "aim12"));
        aims.add(new Aim(null, per2, ts1_1, "aim13"));
        aims.add(new Aim(null, per2, ts2_2, "aim14"));
        aims.add(new Aim(null, per2, ts3_3, "aim15"));
        aims.add(new Aim(null, per2, ts4_4, "aim16"));

        AimSchedule schedule = new AimSchedule();
        schedule.setPersons(persons);
        schedule.setTimeSlots(timeSlots);
        schedule.setActivities(activities);
        schedule.setAims(aims);

        return schedule;
    }

    public static AimSchedule generateData3() {
        var per1 = new Person("Andy D.");
        var per2 = new Person("Evan C.");
        var per3 = new Person("Anna V.");
        List<Person> persons = List.of(per1, per2, per3);

        var dt1 = LocalDate.of(2022, 12, 1);

        var ts1 = new TimeSlot(LocalTime.of(9,0), LocalTime.of(9, 30), dt1);
        var ts2 = new TimeSlot(LocalTime.of(9,30), LocalTime.of(10, 00), dt1);
        var ts3 = new TimeSlot(LocalTime.of(10,00), LocalTime.of(10, 30), dt1);
        var ts4 = new TimeSlot(LocalTime.of(10,30), LocalTime.of(11, 00), dt1);
        List<TimeSlot> timeSlots = List.of(ts1, ts2, ts3, ts4);

        var act1 = new Activity("Activity1", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 20), dt1));
        var act2 = new Activity("Activity2", new TimeSlot(LocalTime.of(9, 10), LocalTime.of(9, 25), dt1));
        var act3 = new Activity("Activity3", new TimeSlot(LocalTime.of(10, 10), LocalTime.of(10, 55), dt1));
        var act4 = new Activity("Activity4", new TimeSlot(LocalTime.of(10, 20), LocalTime.of(10, 50), dt1));
        var act5 = new Activity("Activity5", new TimeSlot(LocalTime.of(9, 05), LocalTime.of(10, 25), dt1));
        var act6 = new Activity("Activity6", new TimeSlot(LocalTime.of(10, 05), LocalTime.of(10, 20), dt1));
        List<Activity> activities = new LinkedList<>();
        activities.add(act1);
        activities.add(act2);
        activities.add(act3);
        activities.add(act4);
        activities.add(act5);
        activities.add(act6);

        List<Aim> aims = new LinkedList<>();
        aims.add(new Aim(null, per1, ts1, "aim1"));
        aims.add(new Aim(null, per1, ts2, "aim2"));
        aims.add(new Aim(null, per1, ts3, "aim3"));
        aims.add(new Aim(null, per1, ts4, "aim4"));
        aims.add(new Aim(null, per2, ts1, "aim5"));
        aims.add(new Aim(null, per2, ts2, "aim6"));
        aims.add(new Aim(null, per2, ts3, "aim7"));
        aims.add(new Aim(null, per2, ts4, "aim8"));
        aims.add(new Aim(null, per3, ts1, "aim9"));
        aims.add(new Aim(null, per3, ts2, "aim10"));
        aims.add(new Aim(null, per3, ts3, "aim11"));
        aims.add(new Aim(null, per3, ts4, "aim12"));

        AimSchedule schedule = new AimSchedule();
        schedule.setPersons(persons);
        schedule.setTimeSlots(timeSlots);
        schedule.setActivities(activities);
        schedule.setAims(aims);

        return schedule;
    }

}
