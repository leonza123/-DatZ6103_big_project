package lv.lu.df.combopt.timeplanner.domain;

import java.util.Comparator;

public class AimComparator implements Comparator<Aim> {

    @Override
    public int compare(Aim a1, Aim a2) {
        if (a1.getTimeSlot().getDate().compareTo(a2.getTimeSlot().getDate()) == 0) {
            if (a1.getTimeSlot().getEndTime().compareTo(a2.getTimeSlot().getEndTime()) == 0) {
                return 0;
            } else if (a1.getTimeSlot().getEndTime().compareTo(a2.getTimeSlot().getEndTime()) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (a1.getTimeSlot().getDate().compareTo(a2.getTimeSlot().getDate()) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
