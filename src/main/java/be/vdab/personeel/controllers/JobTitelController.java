package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.JobTitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.services.JobTitelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("jobtitels")
public class JobTitelController {
    private final JobTitelService jobTitelService;

    public JobTitelController(JobTitelService jobTitelService) {
        this.jobTitelService = jobTitelService;
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("jobtitels").addObject("jobtitels", jobTitelService.findAll());
    }

    @GetMapping("{optionalJobTitel}")
    public ModelAndView read(@PathVariable Optional<JobTitel> optionalJobTitel) {
        ModelAndView modelAndView = new ModelAndView("jobtitels");
        optionalJobTitel.ifPresent(jobTitel -> modelAndView.addObject("jobtitel", jobTitel));
        modelAndView.addObject("jobtitels", jobTitelService.findAll());
        return modelAndView;
    }
}
