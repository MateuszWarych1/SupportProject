package com.example.ProjectSupport.Controller;

import com.example.ProjectSupport.Service.ReportService;
import com.example.ProjectSupport.model.ReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController {


    @Autowired
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report")
    public String report(Model model){
        model.addAttribute("reportRequest", new ReportModel());
        return "/report";
    }

    @PostMapping("/report")
    public String report(@ModelAttribute ReportModel reportModel, Model model){
        System.out.println("report request: " + reportModel);
        ReportModel reportUser = reportService.reportUser(reportModel.getLogin(), reportModel.getReport());
        if (reportUser != null){
            model.addAttribute("reportRequest", reportUser.getReport());
            return "/report_done";
        }else {
            return "error_page";
        }
    }

    @GetMapping("/report_done")
    public String reportDone(){
        return "/report_done";
    }
}
