package com.example.backend.service;

import com.example.backend.dao.AppearanceDao;
import com.example.backend.domain.Appearance;
import com.example.backend.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AppearanceService {

    private AppearanceDao appearanceDao;
    private IdWorker idWorker;

    //Spring autowire

    public AppearanceService(AppearanceDao appearanceDao, IdWorker idwWorker) {
        this.appearanceDao = appearanceDao;
        this.idWorker = idWorker;
    }

    public List<Appearance> findAll(){
        return appearanceDao.findAll();
    }

    public Appearance findById(String appearanceId) {
        return appearanceDao.findById(appearanceId).get();
    }

    //public List<Appearance> findByActive() { return appearanceDao.findBy(@PathVariable )}

    public void save(Appearance newAppearance) {
        newAppearance.setId(idWorker.nextId() + "");
        appearanceDao.save(newAppearance);
    }

    public void update(String appearanceId, Appearance updatedAppearance) {
        updatedAppearance.setId(appearanceId);
        appearanceDao.save(updatedAppearance);
    }

    public void delete(String appearanceId) {
        appearanceDao.deleteById(appearanceId);
    }

    public List<Appearance> findByDate(LocalDate startDate, LocalDate endDate){
        return appearanceDao.findAllByCreateTimeBetween(startDate, endDate);
    }

    //public List<Appearance> findAllApproved() { return appearanceDao.findBy();}

    //public List<Appearance> findAllNotApproved() { return appearanceDao.findBy(); }

    //public List<Appearance> findAllCompleted() { return appearanceDao.findBy();}

}
