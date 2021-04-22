package com.sgb.famousbar.repositories;

import com.sgb.famousbar.entities.Stack;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends CrudRepository<Stack, Long> {  
}
