package beans;

import main.*;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Local(UtilizadorBeanLocal.class)
@Stateless(name = "UtilizadorBean")
public class UtilizadorBean implements UtilizadorBeanLocal {

    @Override
    public boolean registarUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito) {
        Utilizador utilizador = null;
        try {
            utilizador=FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(utilizador!=null) {
            return false;
        }

        if (tipoUtilizador.equals("dono")) {
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
        } else {
            // Tipo de utilizador inválido
            return false;
        }
    }

    @Override
    public boolean avaliarUtilizador(String emailDono, String emailPetsitter, int avaliacao, String comentario, String alvo) {
        Review review = FacadeDAOs.createReview();
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        // Dono não existe
        if (dono == null) {
            return false;
        }
        review.setDono(dono);
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        // Petsitter não existe
        if (petsitter == null) {
            return false;
        }
        // Data atual
        review.setData(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
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
        return atualizarRating(dono, petsitter, alvo, avaliacao);
    }

    private boolean atualizarRating(Dono dono, Petsitter petsitter, String alvo, int avaliacao) {
        float avaliacaoMedia;
        int nrAvaliacoes;
        if (alvo.equals("dono")) {
            avaliacaoMedia = dono.getAvaliacaoMedia();
            nrAvaliacoes = dono.getNrAvaliacoes();
            dono.setAvaliacaoMedia(((avaliacaoMedia * nrAvaliacoes) + avaliacao) / (nrAvaliacoes + 1));
            dono.setNrAvaliacoes(nrAvaliacoes + 1);

            try {
                FacadeDAOs.saveDono(dono);
            } catch (PersistentException e) {
                // Erro ao guardar dono
                e.printStackTrace();
                return false;
            }
            return true;
        } else if (alvo.equals("petsitter")) {
            avaliacaoMedia = petsitter.getAvaliacaoMedia();
            nrAvaliacoes = petsitter.getNrAvaliacoes();
            petsitter.setAvaliacaoMedia(((avaliacaoMedia * nrAvaliacoes) + avaliacao) / (nrAvaliacoes + 1));
            petsitter.setNrAvaliacoes(nrAvaliacoes + 1);

            try {
                FacadeDAOs.savePetsitter(petsitter);
            } catch (PersistentException e) {
                // Erro ao guardar petsitter
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Utilizador consultarPerfil(String email, String tipoUtilizador) {
        
        if (tipoUtilizador.equals("dono")) {
            Dono dono = null;
            try {
                dono = FacadeDAOs.getDono(email);
            } catch (PersistentException e) {
                // Dono não existe
                e.printStackTrace();
                return null;
            }
            return dono;
        } else if (tipoUtilizador.equals("petsitter")) {
            Petsitter petsitter = null;
            try {
                petsitter = FacadeDAOs.getPetsitter(email);
            } catch (PersistentException e) {
                // Petsitter não existe
                e.printStackTrace();
                return null;
            }
            return petsitter;
        } else {
            // Tipo de utilizador inválido
            return null;
        }
    }

    @Override
    public boolean editarDados(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, boolean ativo) {
        // Inativação de utilizador por parte do admin
        if (nome == null && !ativo) {
            return inativarUtilizador(email, tipoUtilizador);
        }
        // Editar dados por parte dos utilizadores
        else {
            return editarDadosUtilizador(nome, email, dataNasc, contacto, jardim, morada, password, avatar, tipoUtilizador, concelho, distrito, ativo);
        }
    }

    private boolean inativarUtilizador(String email, String tipoUtilizador) {
        if (tipoUtilizador.equals("dono")) {
            Dono dono = null;
            try {
                dono = FacadeDAOs.getDono(email);
            } catch (PersistentException e) {
                // Dono não existe
                e.printStackTrace();
                return false;
            }
            dono.setAtivo(false);

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
                petsitter = FacadeDAOs.getPetsitter(email);
            } catch (PersistentException e) {
                // Petsitter não existe
                e.printStackTrace();
                return false;
            }
            petsitter.setAtivo(true);

            try {
                FacadeDAOs.savePetsitter(petsitter);
            } catch (PersistentException e) {
                // Erro ao guardar petsitter
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            // Tipo de utilizador inválido
            return false;
        }
    }

    private boolean editarDadosUtilizador(String nome, String email, Date dataNasc, String contacto, boolean jardim, String morada, String password, String avatar, String tipoUtilizador, String concelho, String distrito, boolean ativo) {
        if (tipoUtilizador.equals("dono")) {
            Dono dono = null;
            try {
                dono = FacadeDAOs.getDono(email);
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
            dono.setAtivo(ativo);
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
                petsitter = FacadeDAOs.getPetsitter(email);
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
        } else {
            // Tipo de utilizador inválido
            return false;
        }
    }

    @Override
    public List<Review> consultarReviews(String email, String tipo) {
        List<Review> reviews = null;
        if(tipo.equals("dono")) {
            try {
                reviews = FacadeDAOs.listReviews("donoutilizadoremail = '" + email + "' AND alvo = 'dono'",null);
            } catch (PersistentException e) {
                e.printStackTrace();
            }

        }
        else if (tipo.equals("petsitter")) {
            try {
                reviews = FacadeDAOs.listReviews("petsitterutilizadoremail = '" + email + "' AND alvo = 'petsitter'",null);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
        return reviews;
    }

    @Override
    public String tipoUtilizador(String email) {
        Utilizador user = null;
        try {
            user = FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(user instanceof Dono) {
            return "dono";
        }
        else if (user instanceof Petsitter) {
            return "petsitter";
        }
        else {
            return "";
        }


    }
}