package com.demo.DataReciever.service;

import com.demo.DataReciever.dto.DataDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IDataService {
    String uploadData(MultipartFile file, String fileName, Long timeSent) throws
            IOException;

    byte[] getData(Long id);

    List<DataDTO> getAllFiles();
}
