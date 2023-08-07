package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements  EmployeeDAO{

    // entitymanager tanımlama
    private EntityManager entityManager;

    //constructor injection

    public EmployeeDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // sorgu oluştur
        TypedQuery<Employee> theQuery= entityManager.createQuery
                ("from Employee" , Employee.class);

        //sonuç listesi
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }
}
