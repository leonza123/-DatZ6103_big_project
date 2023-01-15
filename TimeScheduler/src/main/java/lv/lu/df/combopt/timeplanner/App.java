package lv.lu.df.combopt.timeplanner;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lv.lu.df.combopt.timeplanner.constants.Constants;
import lv.lu.df.combopt.timeplanner.domain.*;
import lv.lu.df.combopt.timeplanner.testData.problem0;
import lv.lu.df.combopt.timeplanner.testData.problem1;
import org.optaplanner.benchmark.api.PlannerBenchmark;
import org.optaplanner.benchmark.api.PlannerBenchmarkFactory;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class App {
    public static void main(String[] args) throws IOException {
        /*
        AimSchedule prob1 = problem0.generateData1();
        AimSchedule prob2 = problem0.generateData2();
        AimSchedule prob3 = problem0.generateData3();
        */

        AimSchedule prob1 = problem1.generateData1();
        AimSchedule prob2 = problem1.generateData2();
        AimSchedule prob3 = problem1.generateData3();

        /*
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(problem1);
        */
        PlannerBenchmarkFactory benchmarkFactory = PlannerBenchmarkFactory.createFromXmlResource(
                "lv.lu.df.combopt.timeplanner/benchmarkConfig.xml");
        PlannerBenchmark benchmark = benchmarkFactory.buildPlannerBenchmark(prob1, prob2, prob3);
        benchmark.benchmarkAndShowReportInBrowser();
    }

/*
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Schedule started!");

        SolverFactory<AimSchedule> solverFactory = SolverFactory.create(SolverConfig.createFromXmlResource("lv.lu.df.combopt.timeplanner/solverConfig.xml"));

        //Load the problem
        //AimSchedule problem = generateData();

        //PlannerBenchmarkFactory plannerBenchmarkFactory = PlannerBenchmarkFactory.createFromSolverConfigXmlResource(
        //        "lv.lu.df.combopt.timeplanner/solverConfig.xml");
        //PlannerBenchmark plannerBenchmark = plannerBenchmarkFactory.buildPlannerBenchmark(problem, problem, problem);
        //plannerBenchmark.benchmark();

        PlannerBenchmarkFactory benchmarkFactory = PlannerBenchmarkFactory.createFromXmlResource(
                "lv.lu.df.combopt.timeplanner/benchmarkConfig.xml");
        PlannerBenchmark benchmark = benchmarkFactory.buildPlannerBenchmark(problem);
        benchmark.benchmarkAndShowReportInBrowser();

        //Solve the problem
        //Solver<AimSchedule> solver = solverFactory.buildSolver();
        //AimSchedule solution = solver.solve(problem);

        //ScoreManager<AimSchedule, HardSoftScore> scoreManager = ScoreManager.create(solverFactory);
        //logger.debug(scoreManager.explainScore(solution).getSummary());

        //printResult(solution);

        logger.debug("Schedule ended!");
    }

    public static void printResult(AimSchedule result) {
        logger.debug("Start result show.");

        if (result != null) {
            logger.debug("Result not empty.");

            logger.info("");

            List<Person> persons = result.getPersons();

            for (LocalDate date: result.getTimeSlots().stream().map(x -> x.getDate()).distinct().collect(Collectors.toList())) {
                logger.info(date.toString() + "\t| " + persons.stream().map(person -> person.getName()).collect(Collectors.joining("\t| ")) + "\t| ");
                for (TimeSlot timeSlot : result.getTimeSlots().stream().filter(x -> x.getDate().equals(date)).collect(Collectors.toList())) {
                    var temp = timeSlot.getStartTime().toString() + "-" + timeSlot.getEndTime().toString() + "\t| ";
                    for (Person person : persons) {
                        String aimTitle = result.getAims().stream().filter(aim -> aim != null && aim.getPerson() != null && aim.getActivity() != null && aim.getPerson().getName() == person.getName() && aim.getTimeSlot() == timeSlot)
                                .map(aim -> aim.getActivity().getTitle()).collect(Collectors.joining());

                        if (aimTitle != null && aimTitle.trim().isEmpty()) {
                            temp += "Nothing\t| ";
                        } else {
                            temp += aimTitle + "\t| ";
                        }
                    }
                    logger.info(temp);
                }

                logger.info("");
            }

            logger.info("");
        } else {
            logger.debug("Result is empty.");
        }

        logger.debug("End result show.");
    }
*/

}
