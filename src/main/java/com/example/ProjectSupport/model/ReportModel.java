package com.example.ProjectSupport.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "reports_table")
public class ReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String login;
    private String report;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportModel that = (ReportModel) o;
        return Objects.equals(id, that.id) && Objects.equals(report, that.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, report);
    }

    @Override
    public String toString() {
        return "ReportModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", report='" + report + '\'' +
                '}';
    }
}
