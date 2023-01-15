package lv.lu.df.combopt.timeplanner.score;

import lv.lu.df.combopt.timeplanner.constants.Constants;
import lv.lu.df.combopt.timeplanner.domain.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class AimScheduleEasyScoreCalculator implements EasyScoreCalculator<AimSchedule, HardSoftScore> {
    @Override
    public HardSoftScore calculateScore(AimSchedule aimSchedule) {
        int hardScore = 0, softScore = 0;

        for (Aim aimEl1: aimSchedule.getAims()) {
            for (Aim aimEl2: aimSchedule.getAims()) {
                if (!aimEl1.equals(aimEl2) && aimEl1.getActivity() != null && aimEl2.getActivity() != null && aimEl1.getActivity().getTitle() != Constants.ActivityNone && aimEl2.getActivity().getTitle() != Constants.ActivityNone) {

                    //vienada aktivitate
                    if (aimEl1.getActivity().equals(aimEl2.getActivity())) {

                        //dazados laikos
                        if (aimEl1.getTimeSlot().equals(aimEl2.getTimeSlot())) {
                            hardScore--;
                        }

                        //cita persona
                        if (!aimEl1.getPerson().equals(aimEl2.getPerson())) {
                            hardScore--;
                        }
                    }

                    //vienlaicigas aktivitates
                    if (aimEl1.getTimeSlot().equals(aimEl2.getTimeSlot())) {

                        //viena persona
                        if (aimEl1.getPerson().equals(aimEl2.getPerson())) {
                            hardScore--;
                        }
                    }
                }
            }

            //labak, ja kaut kas tiek darits
            if (aimEl1.getActivity() != null && aimEl1.getActivity().getTitle() == Constants.ActivityNone) {
                softScore--;
            }

            //jabut laika intevala
            if (aimEl1.getActivity() != null && aimEl1.getActivity().getTitle() != Constants.ActivityNone) {

                //jabut noraditajos datumos
                if (!aimEl1.getActivity().getTimeSlot().getDate().equals(aimEl1.getTimeSlot().getDate())) {
                    hardScore--;
                }
                else {

                    //if start time and end time greater then timeslot start time
                    if (aimEl1.getActivity().getTimeSlot().getStartTime().compareTo(aimEl1.getTimeSlot().getStartTime()) < 0 &&
                        aimEl1.getActivity().getTimeSlot().getEndTime().compareTo(aimEl1.getTimeSlot().getStartTime()) < 0
                    ) {
                        hardScore--;
                    }

                    //if start time and end time after  timeslot end time
                    if (aimEl1.getActivity().getTimeSlot().getStartTime().compareTo(aimEl1.getTimeSlot().getEndTime()) > 0 &&
                        aimEl1.getActivity().getTimeSlot().getEndTime().compareTo(aimEl1.getTimeSlot().getEndTime()) > 0
                    ) {
                        hardScore--;
                    }
                }
            }
        }

        //katra aktivitate ir darita
        softScore -= aimSchedule.getActivities().stream().filter(act -> act != null && act.getTitle() != Constants.ActivityNone && !aimSchedule.getAims().stream().anyMatch(aim -> aim != null && aim.getActivity() != null && aim.getActivity().equals(act))).count();

        return HardSoftScore.of(hardScore, softScore);
    }
}
