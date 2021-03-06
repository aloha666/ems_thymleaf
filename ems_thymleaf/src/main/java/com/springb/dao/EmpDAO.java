package com.springb.dao;

import com.springb.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDAO {
    List<Emp> findAll();

    void save (Emp emp);
    void update(Emp emp);
    void delete(String id);
    Emp find(String id);


}
