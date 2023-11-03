package com.demo.DataReciever.dto;


import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataFromClient {
    private String fileName;
    private String fileType;
    private int fileSize;
    private double timeSent;
    private String content;
}
