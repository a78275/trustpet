package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import web.Util;

import javax.ejb.Local;
import javax.ejb.Stateless;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

@Local(AutenticarBeanLocal.class)
@Stateless(name="AutenticarBean")
public class AutenticarBean implements AutenticarBeanLocal {
    @Override
    public boolean autenticar(String email, String password) {
        
        Utilizador utilizador = null;
        try {
            utilizador = FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(utilizador!=null) {
            return utilizador.getPassword().equals(password);
        }
        else {
            return false;
        }
    }

    @Override
    public String validarToken(String token) {
        
        List<Utilizador> utilizadorList = null;
        try {
            utilizadorList = FacadeDAOs.listUtilizadores("token='"+token+"'",null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(utilizadorList!=null && utilizadorList.size()>0) {
            Utilizador utilizador = (Utilizador) utilizadorList.toArray()[0];
            return utilizador.getEmail();
        }
        else {
            return null;
        }
    }

    @Override
    public String setToken(String email) {
        
        Utilizador utilizador = null;
        try {
            utilizador = FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(utilizador!=null) {
            RandomString randomString = new RandomString(20,new SecureRandom(),email);
            String token = randomString.nextString();
            utilizador.setToken(token);

            try {
                FacadeDAOs.saveUtilizador(utilizador);
            } catch (PersistentException e) {
                e.printStackTrace();
            }

            return token;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean autenticarAdministrador(String email, String password) {
        
        // Administrador
        Administrador administrador = null;
        try {
            administrador = FacadeDAOs.getAdministrador(email);
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

    @Override
    public String isAutenticado(String email) {
        
        Utilizador utilizador = null;
        try {
            utilizador = FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(utilizador==null) {
            return null;
        }
        else {
            return utilizador.getToken();
        }
    }

    @Override
    public boolean logout(String email) {
        
        Utilizador utilizador = null;
        try {
            utilizador = FacadeDAOs.getUtilizador(email);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(utilizador!=null) {
            utilizador.setToken("");
            try {
                FacadeDAOs.saveUtilizador(utilizador);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            return true;
        }
        else {
            return false;
        }
    }
}



class RandomString {
    /**
     * Generate a random string.
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String alphanum = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    public RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    public RandomString(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    public RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    public RandomString() {
        this(21);
    }

}