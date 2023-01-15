package lv.lu.df.combopt.timeplanner.rest;

import lv.lu.df.combopt.timeplanner.domain.AimSchedule;
import lv.lu.df.combopt.timeplanner.domain.AimScheduleJsonSolutionFileIO;

import lv.lu.df.combopt.timeplanner.testData.problem0;
import lv.lu.df.combopt.timeplanner.testData.problem1;
import org.optaplanner.core.api.solver.SolverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/optimizer")
public class AimSchedController {

    private AimScheduleJsonSolutionFileIO fileIO = new AimScheduleJsonSolutionFileIO();

    @Autowired
    private SolverManager<AimSchedule, Integer> solverManager;

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        AimSchedule problem = problem0.generateData1();
        solverManager.solve(1, problem);
        return "Hi!";
    }

    @GetMapping("/solveSpecific")
    @ResponseBody
    public AimSchedule solveSpecific(String id) throws ExecutionException, InterruptedException {
        AimSchedule problem;

        switch(id) {
            case "11":
                problem = problem0.generateData1();
                break;
            case "12":
                problem = problem0.generateData2();
                break;
            case "13":
                problem = problem0.generateData3();
                break;
            case "21":
                problem = problem1.generateData1();
                break;
            case "22":
                problem = problem1.generateData2();
                break;
            case "23":
                problem = problem1.generateData3();
                break;
            default:
                problem = problem0.generateData1();
        }

        return solverManager.solve(1, problem).getFinalBestSolution();
    }

    @PostMapping("/solve")
    @ResponseBody
    public AimSchedule solve(@RequestBody AimSchedule problem) throws ExecutionException, InterruptedException {
        return solverManager.solve(1, problem).getFinalBestSolution();
    }
}
