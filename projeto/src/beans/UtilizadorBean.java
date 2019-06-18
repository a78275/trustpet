package beans;

import org.orm.PersistentSession;
import trustpet.Utilizador;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;

@Local(UtilizadorBeanLocal.class)
@Stateless(name="Utilizador")
public class UtilizadorBean implements UtilizadorBeanLocal {

    @Override
    public boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session) {
        return false;
    }

    @Override
    public boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario, PersistentSession session) {
        return false;
    }

    @Override
    public Utilizador consultarPerfil(String email, PersistentSession session) {
        return null;
    }

    @Override
    public boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session) {
        return false;
    }
}