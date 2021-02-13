package com.springb.dao;

import com.springb.entity.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> findAll();

    void save (Emp emp);
    void update(Emp emp);


}
