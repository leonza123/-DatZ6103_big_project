package lv.lu.df.combopt.timeplanner.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

@PlanningEntity(difficultyComparatorClass = AimComparator.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Aim.class)
public class Aim {
    @PlanningId
    private String id;
    @PlanningVariable(valueRangeProviderRefs = "activities")
    private Activity activity;
    private Person person;
    private TimeSlot timeSlot;

    public Aim() {}

    public Aim(Activity activity, Person person, TimeSlot timeSlot, String id)
    {
        setActivity(activity);
        setPerson(person);
        setTimeSlot(timeSlot);
        setId(id);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
