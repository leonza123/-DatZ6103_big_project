package lv.lu.df.combopt.timeplanner.score;

import lv.lu.df.combopt.timeplanner.constants.Constants;
import lv.lu.df.combopt.timeplanner.domain.Activity;
import lv.lu.df.combopt.timeplanner.domain.Aim;
import lv.lu.df.combopt.timeplanner.domain.AimSchedule;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class AimSchedulerConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            //everyAim(constraintFactory),
            somethingDone(constraintFactory),
            samePerson(constraintFactory),
            sameActivity1(constraintFactory),
            sameActivity2(constraintFactory),
            duringDay(constraintFactory),
            duringTime1(constraintFactory),
            duringTime2(constraintFactory),
            everyActivity(constraintFactory)
        };
    }

    private Constraint everyAim(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Aim.class)
                .penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("every Aim");
    }

    private Constraint sameActivity1(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEachUniquePair(Aim.class)
                .filter((aim1, aim2) -> aim1.getActivity().getTitle() != Constants.ActivityNone && aim2.getActivity().getTitle() != Constants.ActivityNone &&
                        aim1.getActivity().equals(aim2.getActivity()) && aim1.getTimeSlot().equals(aim2.getTimeSlot()))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("same Activity at same time");
    }

    private Constraint sameActivity2(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEachUniquePair(Aim.class)
                .filter((aim1, aim2) -> aim1.getActivity().getTitle() != Constants.ActivityNone && aim2.getActivity().getTitle() != Constants.ActivityNone &&
                        aim1.getActivity().equals(aim2.getActivity()) && !aim1.getPerson().equals(aim2.getPerson()))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("same Activity at dif person");
    }

    private Constraint samePerson(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEachUniquePair(Aim.class)
                .filter((aim1, aim2) -> aim1.getActivity().getTitle() != Constants.ActivityNone && aim2.getActivity().getTitle() != Constants.ActivityNone &&
                        aim1.getTimeSlot().equals(aim2.getTimeSlot()) && aim1.getPerson().equals(aim2.getPerson()))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("same Person at dif activity");
    }

    private Constraint somethingDone(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Aim.class)
                .filter(aim -> aim.getActivity() == null || aim.getActivity().getTitle() == Constants.ActivityNone)
                .penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("something Done");
    }

    private Constraint duringDay(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Aim.class)
                .filter(aim -> aim.getActivity() != null && aim.getActivity().getTitle() != Constants.ActivityNone)
                .filter(aim -> aim.getActivity().getTimeSlot() != null && !aim.getActivity().getTimeSlot().getDate().equals(aim.getTimeSlot().getDate()))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Activity at day");
    }

    private Constraint duringTime1(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Aim.class)
                .filter(aim -> aim.getActivity() != null && aim.getActivity().getTimeSlot() != null && aim.getActivity().getTitle() != Constants.ActivityNone &&
                        aim.getActivity().getTimeSlot().getStartTime().compareTo(aim.getTimeSlot().getStartTime()) < 0 &&
                        aim.getActivity().getTimeSlot().getEndTime().compareTo(aim.getTimeSlot().getStartTime()) < 0)
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Activity during start time");
    }

    private Constraint duringTime2(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Aim.class)
                .filter(aim -> aim.getActivity() != null && aim.getActivity().getTimeSlot() != null && aim.getActivity().getTitle() != Constants.ActivityNone &&
                        aim.getActivity().getTimeSlot().getStartTime().compareTo(aim.getTimeSlot().getEndTime()) > 0 &&
                        aim.getActivity().getTimeSlot().getEndTime().compareTo(aim.getTimeSlot().getEndTime()) > 0)
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Activity during end time");
    }

    private Constraint everyActivity(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(Activity.class)
                .filter(activity -> activity.getAimList() != null && activity.getTitle() != Constants.ActivityNone)
                .filter(activity -> !activity.getAimList().stream().anyMatch(aim -> aim.getActivity().getTitle() == activity.getTitle()))
                .penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("each Activity was done");
    }

}
