package com.constelis.constelis.Model;

import java.sql.Date;
import java.time.LocalDateTime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactNeed {

    private final LocalDateTime date;
    private final String needs;
    private final String Ao;
    private final String AoFile;
    private final String status;
    private final String Cv;
    private final String CvFile;
    private final Date Cvsenddate;

    public ContactNeed(LocalDateTime date, String needs, String ao, String aoFile, String status, String cv,
            String cvFile, Date cvsenddate) {
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