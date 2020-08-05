package com.upgrad.taskana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrad.taskana.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
