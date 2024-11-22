package com.mygane.yaro.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "hello_model")
@Table
public class HelloModel {
	@Id
	@Column(name = "hello_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "hello_msg")
	@Setter
	@Getter
	private String message;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	@Column(name = "updated_at", nullable = false, updatable = false)	
	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());;

}
