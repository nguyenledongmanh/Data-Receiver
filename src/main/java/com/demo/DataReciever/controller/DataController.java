package com.demo.DataReciever.controller;

import com.demo.DataReciever.dto.DataDTO;
import com.demo.DataReciever.dto.DataFromClient;
import com.demo.DataReciever.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private IDataService iDataService;

    // create Data
    @PostMapping("")
    public ResponseEntity<String> uploadData(@RequestBody DataFromClient data) throws
            IOException {
        return new ResponseEntity<>(iDataService.uploadData(data), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<DataDTO>> getAllFiles() {
        return ResponseEntity.ok(iDataService.getAllFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getData(@PathVariable Long id) {
        return ResponseEntity.ok(iDataService.getData(id));
    }
}
