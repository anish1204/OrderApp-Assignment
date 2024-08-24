package com.example.demo.repository;


import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{

    @Query(value = "SELECT o FROM orders o WHERE o.nature_of_business = :val")
    List<Orders> findByNature(@Param("val") String natureType);

    @Query(value = "SELECT o FROM orders o WHERE o.manufacturing_processes = :val")
    List<Orders> findByProcess(@Param("val") String natureType);

}
