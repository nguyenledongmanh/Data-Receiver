package com.demo.DataReciever.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data")
@Builder
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "content_length")
    private int fileSize;
    @Column(name = "time_received")
    private Long timeReceived;
    @Column(name = "time_sent")
    private Long timeSent;

    @Lob
    @Column(length = 500*1024)
    private byte[] content;
}
