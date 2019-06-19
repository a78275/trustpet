package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local(AutenticarBeanLocal.class)
@Stateless(name="Autenticar")
public class AutenticarBean implements AutenticarBeanLocal {
    @Override
    public boolean autenticar(String email, String password, PersistentSession session) {
        // Dono
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session, email);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Dono existe
        if(dono != null){
            // Password correta
            if(dono.getPassword().equals(password)){
                return true;
            }
            // Password errada
            else {
                return false;
            }
        }

        // Petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, email);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Dono existe
        if(petsitter != null){
            // Password correta
            if(petsitter.getPassword().equals(password)){
                return true;
            }
            // Password errada
            else {
                return false;
            }
        }

        // Administrador
        Administrador administrador = null;
        try {
            administrador = FacadeDAOs.getAdministrador(session, email);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Administrador existe
        if(administrador != null){
            // Password correta
            if(administrador.getPassword().equals(password)){
                return true;
            }
            // Password errada
            else {
                return false;
            }
        }

        return false;
    }
}