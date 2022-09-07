
package com.portfoio.ma.Security.Service;

import com.portfoio.ma.Security.Entity.Usuario;
import com.portfoio.ma.Security.Repository.iUsuarioRerpository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRerpository iusuarioRerpository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRerpository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRerpository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRerpository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRerpository.save(usuario);
    }
}
