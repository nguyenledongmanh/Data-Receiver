package com.demo.DataReciever.service.impl;

import com.demo.DataReciever.dto.DataFromClient;
import com.demo.DataReciever.entity.Data;
import com.demo.DataReciever.repository.IDataRepository;
import com.demo.DataReciever.service.IDataService;
import com.demo.DataReciever.util.DataUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

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

        Long time_received = new Date().getTime();
        data.setTimeReceived(time_received);
        data.setContent(DataUtils.compressData(dataFromClient.getContent()
                                                             .getBytes()));
        iDataRepository.save(data);
        return "file uploaded successfully: " + dataFromClient.getFileName();
    }
}
