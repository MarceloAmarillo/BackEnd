
package com.portfoio.ma.Controller;

import com.portfoio.ma.Dto.dtoBanner;
import com.portfoio.ma.Entity.Banner;
import com.portfoio.ma.Security.Controller.Mensaje;
import com.portfoio.ma.Service.SBanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = {"https://frontendma.web.app","http://localhost:4200"})

public class CBanner {
   @Autowired
    SBanner sbanner;

    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list() {
        List<Banner> list = sbanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id) {
        if (!sbanner.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Banner banner = sbanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sbanner.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sbanner.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

   @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBanner dtobanner) {
        if (StringUtils.isBlank(dtobanner.getImg())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sbanner.existsByNombre(dtobanner.getImg())) {
            return new ResponseEntity(new Mensaje(" ya existe"), HttpStatus.BAD_REQUEST);
        }

        Banner banner = new Banner(dtobanner.getImg(),dtoBanner.getnombre());
        sbanner.save(banner);

        return new ResponseEntity(new Mensaje("banner agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner) {
        //Validamos si existe el ID
        if (!sbanner.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sbanner.existsByNombre(dtobanner.getImg()) && sbanner.getByNombre(dtobanner.getImg()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtobanner.getImg())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Banner banner = sbanner.getOne(id).get();
        banner.setImg(dtobanner.getImg());
        

        sbanner.save(banner);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
