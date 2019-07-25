package com.shri.spring.boot.repositories;

import com.shri.spring.boot.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: ZeeroIQ
 * @Date: 7/24/2019 12:20 AM
 */
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
