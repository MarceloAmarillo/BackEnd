
package com.portfoio.ma.Interface;

import com.portfoio.ma.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    // traer persona
    public List<Persona> getPersona();
    
    //guarda una persona
    public void savePersona(Persona persona);
    
    //eliminar un usuario
    public void deletePersona(Long id);
    
    //buscar persona
    public Persona findPersona(Long id);
}
