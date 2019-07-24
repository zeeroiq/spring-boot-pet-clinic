package com.shri.spring.boot.repositories;

import com.shri.spring.boot.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: ZeeroIQ
 * @Date: 7/24/2019 12:20 AM
 */
public interface VisitRepository extends CrudRepository<Owner, Long> {
}
