package com.shri.spring.boot.service;

import com.shri.spring.boot.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
