package eu.unareil.dal;

import eu.unareil.bo.Pain;
import eu.unareil.dal.xmlimpl.DAOXmlompl;
import eu.unareil.dal.xmlimpl.Settings;

import java.io.IOException;

public class DAOFactory {
    public static DAO<Pain> getPainDAO() {
        DAO<Pain> painDAO = new DAOXmlompl();
        return painDAO;
    }
    public static String getURL(){

        return Settings.getProperty("urlxml");

    }
    public static void setURL(String value) throws DALException{

        try {
            Settings.setProperty(value);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur d'écriture du xml",e);
        }

    }
}
