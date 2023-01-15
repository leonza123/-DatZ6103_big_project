package lv.lu.df.combopt.timeplanner.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.optaplanner.persistence.jackson.impl.domain.solution.JacksonSolutionFileIO;

public class AimScheduleJsonSolutionFileIO extends JacksonSolutionFileIO<AimSchedule> {
    public AimScheduleJsonSolutionFileIO() {
        super(AimSchedule.class, new ObjectMapper().registerModule(new JavaTimeModule()).findAndRegisterModules());
    }
}