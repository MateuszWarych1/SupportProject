package com.example.ProjectSupport.Repo;

import com.example.ProjectSupport.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepo extends JpaRepository<ReportModel, Integer> {

    Optional<ReportModel> findById(Integer id);
}
