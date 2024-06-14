package com.tka.OrganizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	String name;
	String department;
	String status;
	String phoneno;
	double salary;
    Date createdtm;
    String createdby;
    Date updateddtm;
    String updatedby;
    @Column(unique = true)
    String emailid;
    
    @ManyToOne
    @JoinColumn(name="c_id")
    Country country;    
}
