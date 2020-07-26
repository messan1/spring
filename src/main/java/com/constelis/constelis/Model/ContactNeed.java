package com.constelis.constelis.Model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactNeed {

    private final LocalDateTime date;
    private final String needs;
    private final String Ao;
    private final String AoFile;
    private final String status;
    private final String Cv;
    private final String CvFile;
    private final Date Cvsenddate;

    public ContactNeed(@JsonProperty("date") LocalDateTime date, @JsonProperty("needs") String needs,
            @JsonProperty("ao") String ao, @JsonProperty("aoFile") String aoFile, @JsonProperty("status") String status,
            @JsonProperty("cv") String cv, @JsonProperty("cvFile") String cvFile,
            @JsonProperty("cvsenddate") Date cvsenddate) {
        this.date = date;
        this.needs = needs;
        Ao = ao;
        AoFile = aoFile;
        this.status = status;
        Cv = cv;
        CvFile = cvFile;
        Cvsenddate = cvsenddate;
    }

    public Date getCvsenddate() {
        return Cvsenddate;
    }

    public String getCvFile() {
        return CvFile;
    }

    public String getCv() {
        return Cv;
    }

    public String getStatus() {
        return status;
    }

    public String getAoFile() {
        return AoFile;
    }

    public String getAo() {
        return Ao;
    }

    public String getNeeds() {
        return needs;
    }

    public LocalDateTime getDate() {
        return date;
    }

}