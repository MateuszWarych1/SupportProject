package com.example.ProjectSupport.Service;

import com.example.ProjectSupport.Repo.ReportRepo;
import com.example.ProjectSupport.model.ReportModel;
import org.springframework.stereotype.Service;

@Service
public class ReportService {


    private final ReportRepo reportRepo;

    public ReportService(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    public ReportModel reportUser(String login, String report){
        if (report == null){
            return null;
        } else {
            ReportModel reportModel = new ReportModel();
            reportModel.setLogin(login);
            reportModel.setReport(report);
            return reportRepo.save(reportModel);
        }
    }
}
