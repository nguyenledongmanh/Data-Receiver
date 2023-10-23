package com.demo.DataReciever.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data", uniqueConstraints = @UniqueConstraint(columnNames = {"file_name"}))
@Builder
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "file_name", nullable = false)
    private String fileName;
    @Column(name = "file_type", nullable = false)
    private String fileType;
    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @CreationTimestamp
    @Column(name = "time_received")
    private Date timeReceived;
    @Column(name = "time_sent", nullable = false)
    private Long timeSent;
    @Lob
    @Column(name = "file_content", length = 1000000)
    private byte[] content;
}
