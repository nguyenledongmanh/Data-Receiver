package com.demo.DataReciever.service;

import com.demo.DataReciever.dto.DataDTO;
import com.demo.DataReciever.dto.DataFromClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IDataService {
    String uploadData(DataFromClient data) throws
            IOException;

    List<DataDTO> getAllFiles();
}
