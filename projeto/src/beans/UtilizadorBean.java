package beans;

import trustpet.Utilizador;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;

@Local(UtilizadorBeanLocal.class)
@Stateless(name="Utilizador")
public class UtilizadorBean implements UtilizadorBeanLocal {

    @Override
    public boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
        return false;
    }

    @Override
    public boolean avaliarUtilizador(String de, String para, int avaliacao, String comentario) {
        return false;
    }

    @Override
    public Utilizador consultarPerfil(String email) {
        return null;
    }

    @Override
    public void editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {

    }
}