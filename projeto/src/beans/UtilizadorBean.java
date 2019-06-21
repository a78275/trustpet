package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Local(UtilizadorBeanLocal.class)
@Stateless(name="UtilizadorBean")
public class UtilizadorBean implements UtilizadorBeanLocal {

    @Override
    public boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session) {
        if(tipoUtilizador.equals("dono")) {
            Dono dono = FacadeDAOs.createDono();
            dono.setNome(nome);
            dono.setEmail(email);
            dono.setPassword(password);
            dono.setContacto(contacto);
            dono.setJardim(jardim);
            dono.setMorada(morada);
            dono.setAvatar(avatar);
            dono.setConcelho(concelho);
            dono.setDistrito(distrito);
            dono.setAtivo(true);
            dono.setAvaliacaoMedia(0);
            dono.setNrAvaliacoes(0);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            dono.setDataNasc(format.format(dataNasc));
            try {
                FacadeDAOs.saveDono(dono);
            } catch (PersistentException e) {
                // Erro ao guardar dono
                e.printStackTrace();
                return false;
            }
            return true;
        } else if (tipoUtilizador.equals("petsitter")) {
            Petsitter petsitter = FacadeDAOs.createPetsitter();
            petsitter.setNome(nome);
            petsitter.setEmail(email);
            petsitter.setPassword(password);
            petsitter.setContacto(contacto);
            petsitter.setJardim(jardim);
            petsitter.setMorada(morada);
            petsitter.setAvatar(avatar);
            petsitter.setConcelho(concelho);
            petsitter.setDistrito(distrito);
            petsitter.setAtivo(true);
            petsitter.setAvaliacaoMedia(0);
            petsitter.setNrAvaliacoes(0);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            petsitter.setDataNasc(format.format(dataNasc));
            Horario horario = FacadeDAOs.createHorario();
            petsitter.setHorario(horario);
            try {
                FacadeDAOs.savePetsitter(petsitter);
            } catch (PersistentException e) {
                // Erro ao guardar petsitter
                e.printStackTrace();
                return false;
            }
            return true;
        }
        else {
            // Tipo de utilizador inválido
            return false;
        }
    }

    @Override
    public boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo, PersistentSession session) {
        Review review = FacadeDAOs.createReview();
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session,emailDono);
        } catch (PersistentException e) {
            // Dono não existe
            e.printStackTrace();
            return false;
        }
        review.setDono(dono);
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session,emailPetsitter);
        } catch (PersistentException e) {
            // Petsitter não existe
            e.printStackTrace();
            return false;
        }
        review.setPetsitter(petsitter);
        review.setAlvo(alvo);
        review.setComentario(comentario);
        review.setPontuacao(avaliacao);
        try {
            FacadeDAOs.saveReview(review);
        } catch (PersistentException e) {
            // Erro ao guardar review
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Utilizador consultarPerfil(String email, String tipoUtilizador,PersistentSession session) {
        if(tipoUtilizador.equals("dono")) {
            Dono dono = null;
            try {
                dono = FacadeDAOs.getDono(session,email);
            } catch (PersistentException e) {
                // Dono não existe
                e.printStackTrace();
                return null;
            }
            return dono;
        } else if (tipoUtilizador.equals("dono")) {
            Petsitter petsitter = null;
            try {
                petsitter = FacadeDAOs.getPetsitter(session,email);
            } catch (PersistentException e) {
                // Petsitter não existe
                e.printStackTrace();
                return null;
            }
            return petsitter;
        }
        else {
            // Tipo de utilizador inválido
            return null;
        }
    }

    @Override
    public boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, PersistentSession session) {
        if(tipoUtilizador.equals("dono")) {
            Dono dono = null;
            try {
                dono = FacadeDAOs.getDono(session,email);
            } catch (PersistentException e) {
                // Dono não existe
                e.printStackTrace();
                return false;
            }
            dono.setNome(nome);
            dono.setEmail(email);
            dono.setPassword(password);
            dono.setContacto(contacto);
            dono.setJardim(jardim);
            dono.setMorada(morada);
            dono.setAvatar(avatar);
            dono.setConcelho(concelho);
            dono.setDistrito(distrito);
            dono.setAtivo(true);
            dono.setAvaliacaoMedia(0);
            dono.setNrAvaliacoes(0);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            dono.setDataNasc(format.format(dataNasc));
            try {
                FacadeDAOs.saveDono(dono);
            } catch (PersistentException e) {
                // Erro ao guardar dono
                e.printStackTrace();
                return false;
            }
            return true;
        } else if (tipoUtilizador.equals("petsitter")) {
            Petsitter petsitter = null;
            try {
                petsitter = FacadeDAOs.getPetsitter(session,email);
            } catch (PersistentException e) {
                // Petsitter não existe
                e.printStackTrace();
                return false;
            }
            petsitter.setNome(nome);
            petsitter.setEmail(email);
            petsitter.setPassword(password);
            petsitter.setContacto(contacto);
            petsitter.setJardim(jardim);
            petsitter.setMorada(morada);
            petsitter.setAvatar(avatar);
            petsitter.setConcelho(concelho);
            petsitter.setDistrito(distrito);
            petsitter.setAtivo(true);
            petsitter.setAvaliacaoMedia(0);
            petsitter.setNrAvaliacoes(0);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            petsitter.setDataNasc(format.format(dataNasc));
            try {
                FacadeDAOs.savePetsitter(petsitter);
            } catch (PersistentException e) {
                // Erro ao guardar petsitter
                e.printStackTrace();
                return false;
            }
            return true;
        }
        else {
            // Tipo de utilizador inválido
            return false;
        }
    }
}