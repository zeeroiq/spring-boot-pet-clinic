package com.shri.spring.boot.service.map;

import com.shri.spring.boot.model.PetType;
import com.shri.spring.boot.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/21/2019
 */

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
