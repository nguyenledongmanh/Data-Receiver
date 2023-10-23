package com.demo.DataReciever.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private Long fileSize;
    private Long timeReceivedUnix;
    private Long timeSent;
}
