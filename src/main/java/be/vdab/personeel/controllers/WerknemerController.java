package be.vdab.personeel.controllers;

import be.vdab.personeel.constraints.RijksregisterNummer;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.forms.OpslagForm;
import be.vdab.personeel.forms.RijksregisterForm;
import be.vdab.personeel.services.DefaultWerknemerService;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
@RequestMapping("werknemers")
public class WerknemerController {

    private final DefaultWerknemerService werknemerService;

    public WerknemerController(DefaultWerknemerService werknemerService) {
        this.werknemerService = werknemerService;
    }

    @GetMapping
    public ModelAndView index() {

        return new ModelAndView("werknemers").addObject("werknemer", werknemerService.findByChefIsNull());
    }


    @GetMapping("{optionalWerknemer}")
    public ModelAndView read(@PathVariable Optional<Werknemer> optionalWerknemer) {
        ModelAndView modelAndView = new ModelAndView("werknemers");
        optionalWerknemer.ifPresent(werknemer -> modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }

    @GetMapping("{optionalWerknemer}/opslag")
    public ModelAndView opslag(@PathVariable Optional<Werknemer> optionalWerknemer) {
        ModelAndView modelAndView = new ModelAndView("opslag").addObject(new OpslagForm(null));
        optionalWerknemer.ifPresent(werknemer -> modelAndView.addObject("werknemer", werknemer));
        return modelAndView;

    }

    @PostMapping("{optionalWerknemer}/opslag")
    public String opslagInDB(@PathVariable Optional<Werknemer> optionalWerknemer, @Valid OpslagForm form, Errors errors) {
        optionalWerknemer.ifPresent(werknemer -> {
            if(!errors.hasErrors()){
            werknemer.opslag(form.getOpslag());
            werknemerService.opslagDatabank(werknemer);

            }

        });

        return "index";


    }

    @GetMapping("{optionalWerknemer}/rijksregisternummer")
    public ModelAndView rijksregisterNummer(@PathVariable Optional<Werknemer> optionalWerknemer) {
        ModelAndView modelAndView = new ModelAndView("rijksregister");
        optionalWerknemer.ifPresent(werknemer -> modelAndView.addObject("werknemer", werknemer)
                .addObject(new RijksregisterForm(werknemer.getRijksRegisterNr(), werknemer))
        );
        return modelAndView;

    }

    @PostMapping("{optionalWerknemer}/rijksregister")
    public ModelAndView updateRijksInDB(@PathVariable Optional<Werknemer> optionalWerknemer, @Valid @NotNull RijksregisterForm form, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("rijksregister");
        final boolean[] ok = {false};

        optionalWerknemer.ifPresent(werknemer -> {
            if (errors.hasErrors()) {
                modelAndView.addObject("werknemer", werknemer).addObject("rijksregister", new RijksregisterForm(werknemer.getRijksRegisterNr(), werknemer));
                ok[0] = true;
            } else {
                werknemer.updateRijksRegisterNr(form.getNr());
                werknemerService.opslagDatabank(werknemer);
            }
        });

        if(ok[0]){
            return modelAndView;
        }
        return new ModelAndView("index");
    }


}
