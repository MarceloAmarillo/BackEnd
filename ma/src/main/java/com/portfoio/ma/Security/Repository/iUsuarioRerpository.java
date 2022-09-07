
package com.portfoio.ma.Security.Repository;

import com.portfoio.ma.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iUsuarioRerpository extends JpaRepository<Usuario, Integer >{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario );
    boolean existsByEmail(String email );
}
