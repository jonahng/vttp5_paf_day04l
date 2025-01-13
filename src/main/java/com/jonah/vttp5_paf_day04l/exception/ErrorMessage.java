package com.jonah.vttp5_paf_day04l.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //these are the equivalent of doing getters setters constructors
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
    private Date timeStamp;
    private String endPoint;

    
}
