package com.example.backend.service;

import com.example.backend.dao.AppearanceDao;
import com.example.backend.domain.Appearance;
import com.example.backend.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
