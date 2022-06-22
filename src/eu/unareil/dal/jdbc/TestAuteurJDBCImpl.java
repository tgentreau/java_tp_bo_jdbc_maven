package eu.unareil.dal.jdbc;

import eu.unareil.bo.Auteur;
import eu.unareil.dal.DALException;


import java.util.List;

public class TestAuteurJDBCImpl {
    public static void main(String[] args) {
        AuteurJDBCImpl auteurJDBC = new AuteurJDBCImpl();
        //Insert
        try{
            Auteur auteur = new Auteur("Lulu", "Lolo");
            auteurJDBC.insert(auteur);
        } catch (DALException e) {
            e.printStackTrace();
        }
        // Select All
//        try{
//            List<Auteur> auteurs = auteurJDBC.selectAll();
//            for (Auteur auteur : auteurs) {
//                System.out.println(auteur);
//            }
//        } catch (DALException e) {
//            e.printStackTrace();
//        }

//        // Select By Id
//        try{
//            Auteur unAuteur = auteurJDBC.selectById(5);
//            System.out.println(unAuteur);
//        } catch (DALException e) {
//            e.printStackTrace();
//        }
//        //Update
//        try{
//            Auteur auteur = new Auteur(5,"Marcel", "Marcel");
//            auteurJDBC.update(auteur);
//        } catch (DALException e) {
//            e.printStackTrace();
//        }

//        //Delete
//        try{
//            Auteur auteur = new Auteur(5,"Roger", "Marcel");
//            auteurJDBC.delete(auteur);
//        } catch (DALException e) {
//            e.printStackTrace();
//        }

    }
}
