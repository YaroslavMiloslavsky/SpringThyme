package com.mygane.yaro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mygane.yaro.demo.model.HelloModel;

@Repository
public interface HelloRepository extends JpaRepository<HelloModel, Long> {

}
