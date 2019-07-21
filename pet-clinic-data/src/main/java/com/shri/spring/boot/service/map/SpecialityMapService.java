package com.shri.spring.boot.service.map;

import com.shri.spring.boot.model.Speciality;
import com.shri.spring.boot.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Authon: ZeeroIQ
 * @Date: 7/22/2019
 */
@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
