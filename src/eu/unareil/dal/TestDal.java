package eu.unareil.dal;

import eu.unareil.bo.Pain;

import java.util.ArrayList;
import java.util.List;

public class TestDal {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DAO<Pain> maDAO = DAOFactory.getPainDAO();
        List<Pain> pains = new ArrayList<>();

        try {
            Pain pain= new Pain("Boulangerie Ducoin","pain tradition", 400, 100, 2.0f);
            maDAO.insert(pain);
            pain= new Pain("Boulangerie Ducoin","baguette ordinaire", 250, 800, 0.8f);
            maDAO.insert(pain);
            pain= new Pain("Boulangerie Ducoin","pain ordinaire", 400, 600, 1.5f);
            maDAO.insert(pain);
            pains=maDAO.selectAll();
            for(Pain st : pains)
            {
                System.out.println(st.getRefProd()+"-"+st.getLibelle()+"-"+st.getMarque()+"-"+ st.getPoids()+"-"+ st.getPrixUnitaire()+"-"+st.getQteStock());
            }
            maDAO.delete(5);
            System.out.println("-----------------------------------");
            Pain pain1 = maDAO.selectById(3);
            System.out.println(pain1.getRefProd()+"-"+pain1.getLibelle()+"-"+pain1.getMarque()+"-"+ pain1.getPoids()+"-"+ pain1.getPrixUnitaire()+"-"+pain1.getQteStock());
            pain1.setLibelle("Test");
            maDAO.update(pain1);
            pains=maDAO.selectAll();
            for(Pain st : pains)
            {
                System.out.println(st.getRefProd()+"-"+st.getLibelle()+"-"+st.getMarque()+"-"+ st.getPoids()+"-"+ st.getPrixUnitaire()+"-"+st.getQteStock());
            }
            maDAO.update(pain1);
            System.out.println("-----------------------------------");
            pain1 = maDAO.selectById(3);
            System.out.println(pain1.getRefProd()+"-"+pain1.getLibelle()+"-"+pain1.getMarque()+"-"+ pain1.getPoids()+"-"+ pain1.getPrixUnitaire()+"-"+pain1.getQteStock());
            System.out.println("-----------------------------------");
            pain1 = new Pain("Boulangerie Ducoin","petit pain", 400, 600, 1.5f);
            maDAO.insert(pain1);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
