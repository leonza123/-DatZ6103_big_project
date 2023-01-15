package lv.lu.df.combopt.timeplanner.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.InverseRelationShadowVariable;
import org.optaplanner.core.api.domain.variable.ShadowVariable;

import java.util.ArrayList;
import java.util.List;

@PlanningEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "title", scope = Activity.class)
public class Activity {
    private String title;
    private TimeSlot timeSlot;

    @InverseRelationShadowVariable(sourceVariableName = "activity")
    private List<Aim> aimList;

    public Activity()
    {
        setAimList(new ArrayList<>());
    }

    public Activity(String title, TimeSlot timeSlot)
    {
        setTitle(title);
        setTimeSlot(timeSlot);
        setAimList(new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public List<Aim> getAimList() {
        return aimList;
    }

    public void setAimList(List<Aim> aimList) {
        this.aimList = aimList;
    }
}
