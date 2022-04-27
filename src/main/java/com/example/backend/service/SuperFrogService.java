package com.example.backend.service;

import com.example.backend.dao.AppearanceDao;
import com.example.backend.dao.SuperFrogDao;
import com.example.backend.domain.Appearance;
import com.example.backend.domain.SuperFrog;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SuperFrogService {
    private SuperFrogDao superFrogDao;
    private AppearanceDao appearanceDao;

    public SuperFrogService(SuperFrogDao superFrogDao, AppearanceDao appearanceDao) {
        this.superFrogDao = superFrogDao;
        this.appearanceDao = appearanceDao;
    }

    public List<SuperFrog> findAll() {
        return superFrogDao.findAll();
    }

    public SuperFrog findById(Integer id) {
        return superFrogDao.findById(id).get();
    }

    public void save(SuperFrog superFrog) {
        superFrogDao.save(superFrog);
    }

    public void update(Integer id, SuperFrog superFrog) {
        superFrog.setId(id);
        superFrogDao.save(superFrog);
    }

    public void deleteById(Integer id) {
        superFrogDao.deleteById(id);
    }

    public void assignAppearance(Integer superFrogId, String appearanceId) {
        Appearance appearanceToBeAssigned = appearanceDao.findById(appearanceId).get();
        SuperFrog superFrog = superFrogDao.findById(superFrogId).get();

        if(appearanceToBeAssigned.getAssigned() != null){
            appearanceToBeAssigned.getAssigned().removeAppearance(appearanceToBeAssigned);
        }
        superFrog.addAppearance(appearanceToBeAssigned);
    }
}
