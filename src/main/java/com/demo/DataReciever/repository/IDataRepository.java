package com.demo.DataReciever.repository;

import com.demo.DataReciever.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDataRepository extends JpaRepository<Data, Long> {
}
