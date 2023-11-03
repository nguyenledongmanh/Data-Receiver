package com.demo.DataReciever.service;

import com.demo.DataReciever.dto.DataFromClient;

import java.io.IOException;
import java.util.List;

public interface IDataService {
    String uploadData(DataFromClient data) throws
            IOException;
}
