package com.constelis.constelis.Model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ContactNeed {
   
    @Id
    private final String id;
    private final Date date;
    private final String needs;
    private final String Ao;
    private final String AoFile;
    private final String status;
    private final String Cv;
    private final String CvFile;
    private final Date Cvsenddate;

    public ContactNeed(String id, Date date, String needs, String ao, String aoFile, String status, String cv,
            String cvFile, Date cvsenddate) {
        this.id = id;
        this.date = date;
        this.needs = needs;
        Ao = ao;
        AoFile = aoFile;
        this.status = status;
        Cv = cv;
        CvFile = cvFile;
        Cvsenddate = cvsenddate;
    }
}