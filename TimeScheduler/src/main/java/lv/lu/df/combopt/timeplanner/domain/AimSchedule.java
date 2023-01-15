package lv.lu.df.combopt.timeplanner.domain;

import lv.lu.df.combopt.timeplanner.constants.Constants;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.LinkedList;
import java.util.List;

@PlanningSolution
public class AimSchedule {
    @PlanningEntityCollectionProperty
    private List<Aim> aims;
    @ProblemFactCollectionProperty
    private List<Person> persons;
    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "activities")
    private List<Activity> activities;
    @ProblemFactCollectionProperty
    private List<TimeSlot> timeSlots;

    @PlanningScore
    private HardSoftScore score;

    public AimSchedule()
    {
        setAims(new LinkedList<>());
        setPersons(new LinkedList<>());
        setActivities(new LinkedList<>());
        setTimeSlots(new LinkedList<>());
    }

    public List<Aim> getAims() {
        return aims;
    }

    public void setAims(List<Aim> aims) {
        this.aims = aims;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        //add null activity
        if (activities != null && !activities.stream().anyMatch(x -> x.getTitle() == Constants.ActivityNone)) {
            var act0 = new Activity(Constants.ActivityNone, null);
            activities.add(act0);
        }
        this.activities = activities;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
