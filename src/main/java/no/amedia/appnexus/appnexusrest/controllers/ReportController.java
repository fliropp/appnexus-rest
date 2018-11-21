package no.amedia.appnexus.appnexusrest.controllers;

import no.amedia.appnexus.appnexusrest.model.appnexus.report.Report;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.CreateReport;
import no.amedia.appnexus.appnexusrest.service.AppnexusReporting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    AppnexusReporting appnexusReporting;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(CreateReport createReport, Model model) {
        model.addAttribute("createReport", createReport);
        model.addAttribute("publisher", new String());
        return new ModelAndView("home", "model", model);
    }

    @RequestMapping(value="/report", method = RequestMethod.POST)
    public ModelAndView report(@Valid CreateReport createReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("home", "createReport", new CreateReport());
        }
        List<Report> report = appnexusReporting.generateReport(createReport);

        return new ModelAndView("fragments/report", "report", report);
    }

    @RequestMapping(value="/report/{publisher}", method = RequestMethod.POST)
    public ModelAndView reportPublisher(@RequestParam("publisher") String publisher, @Valid CreateReport createReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("home", "createReport", new CreateReport());
        }
        List<Report> report = appnexusReporting.generateReport(createReport, publisher);
        return new ModelAndView("fragments/report", "report", report);
    }

}
