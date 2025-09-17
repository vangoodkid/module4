package com.example.btvn.repo;

import com.example.btvn.entity.Operation;

import java.util.List;

public interface IOperationRepo {
    List<Operation> findAll();
    Operation findBySymbol(String symbol);
}
