
package com.portfoio.ma.Service;

import com.portfoio.ma.Entity.Banner;
import com.portfoio.ma.Repository.RBanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SBanner {
    @Autowired
    RBanner rbanner;
        public List<Banner> list() {
        return rbanner.findAll();
    }
    
    public Optional<Banner> getOne(int id){
        return rbanner.findById(id);
    }
    
    public Optional<Banner> getByNombre(String nombre){
        return rbanner.findByNombre(nombre);
    }
    
    public void save(Banner banner){
        rbanner.save(banner);
    }
    
    public void delete( int id){
        rbanner.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rbanner.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rbanner.existsByNombre(nombre);
    }

}

