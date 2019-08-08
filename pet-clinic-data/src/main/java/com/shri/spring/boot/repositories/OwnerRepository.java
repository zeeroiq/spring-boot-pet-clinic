package com.shri.spring.boot.repositories;

import com.shri.spring.boot.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: ZeeroIQ
 * @Date: 7/24/2019 12:20 AM
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
