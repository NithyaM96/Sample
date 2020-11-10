package com.result.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.result.model.StudentResult;

@Repository
public interface ResultRepository extends CrudRepository<StudentResult, String> {

	StudentResult findByRegno(int regno);

	List<StudentResult> findAllByRegno(int regno);

	StudentResult findFirstByRegno(int regno);

	boolean existsByRegno(int regno);

}
