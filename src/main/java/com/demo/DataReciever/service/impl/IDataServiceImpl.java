package com.demo.DataReciever.service.impl;

import com.demo.DataReciever.dto.DataDTO;
import com.demo.DataReciever.dto.DataFromClient;
import com.demo.DataReciever.entity.Data;
import com.demo.DataReciever.repository.IDataRepository;
import com.demo.DataReciever.service.IDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class IDataServiceImpl
        implements IDataService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDataRepository iDataRepository;

    @Override
    public String uploadData(DataFromClient dataFromClient) throws
            IOException {
        Data data = modelMapper.map(dataFromClient, Data.class);

        byte[] bytes = dataFromClient.getContentStr()
                                     .getBytes();
        data.setContent(bytes);
        Long time_received = new Date().getTime();
        data.setTimeReceived(time_received);
        iDataRepository.save(data);
        return "file uploaded successfully: " + dataFromClient.getFileName();
    }

    @Override
    public List<DataDTO> getAllFiles() {
        List<Data> dataList = iDataRepository.findAll();
        return dataList.stream()
                       .map((data) -> {
                           DataDTO dataDTO = modelMapper.map(data, DataDTO.class);
                           dataDTO.setTimeReceivedUnix(data.getTimeReceived());
                           return dataDTO;
                       })
                       .toList();
    }
}
