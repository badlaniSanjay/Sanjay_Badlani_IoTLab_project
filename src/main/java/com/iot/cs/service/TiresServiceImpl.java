package com.iot.cs.service;

import com.iot.cs.DAO.TiresDAO;
import com.iot.cs.model.Tires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TiresServiceImpl implements TiresService{
    
    private TiresDAO tiresDAO;

    public TiresServiceImpl() {
    }
    
    @Autowired
    public TiresDAO getTiresDAO() {
        return tiresDAO;
    }

    public void setTiresDAO(TiresDAO tiresDAO) {
        this.tiresDAO = tiresDAO;
    }
    
    
    
    @Override
    public void save(Tires tires) {
        
    }
    
}
