package no.amedia.appnexus.appnexusrest.controllers;

import no.amedia.appnexus.appnexusrest.model.appnexus.report.Report;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.ReportModel;
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
    public ModelAndView home(ReportModel reportModel, String publisher, Model model) {
        return new ModelAndView("home", "reportModel", reportModel);
    }

    @RequestMapping(value="/report", method = RequestMethod.POST)
    public ModelAndView report(@Valid ReportModel reportModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("home", "createReport", new ReportModel());
        }
        List<Report> report = appnexusReporting.generateReport(reportModel.getCreateReport(), reportModel.getPublisher());

        return new ModelAndView("fragments/report", "report", report);
    }


}
