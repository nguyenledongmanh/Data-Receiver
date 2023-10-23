package com.demo.DataReciever.service.impl;

import com.demo.DataReciever.dto.DataDTO;
import com.demo.DataReciever.entity.Data;
import com.demo.DataReciever.repository.IDataRepository;
import com.demo.DataReciever.service.IDataService;
import com.demo.DataReciever.util.DataUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IDataServiceImpl
        implements IDataService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDataRepository iDataRepository;

    @Override
    public String uploadData(MultipartFile file, String fileName, LocalDateTime timeSent) throws
            IOException {
        Data data = iDataRepository.save(Data.builder()
                                             .fileName(fileName)
                                             .fileSize(file.getSize())
                                             .fileType(file.getContentType())
                                             .timeSent(timeSent)
                                             .content(DataUtils.compressData(file.getBytes()))
                                             .build());
        return "file uploaded successfully: " + fileName;
    }

    @Override
    public byte[] getData(Long id) {
        Optional<Data> data = iDataRepository.findById(id);
        return data.map(value -> DataUtils.decompressImage(value.getContent()))
                   .orElse(null);
    }

    @Override
    public List<DataDTO> getAllFiles() {
        return iDataRepository.findAll()
                              .stream()
                              .map((element) -> modelMapper.map(element, DataDTO.class))
                              .toList();
    }
}
