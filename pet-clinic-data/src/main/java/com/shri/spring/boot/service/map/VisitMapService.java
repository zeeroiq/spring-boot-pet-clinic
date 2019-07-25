package com.shri.spring.boot.service.map;

import com.shri.spring.boot.model.Visit;
import com.shri.spring.boot.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: ZeeroIQ
 * @Date: 7/25/2019 8:30 AM
 */
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
