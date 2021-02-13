package com.springb.service;

import com.springb.entity.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    List<Emp> findAll();
    void save(Emp emp);
    void update(Emp emp);
    Emp find(String id);
    void delete(String id);
}
