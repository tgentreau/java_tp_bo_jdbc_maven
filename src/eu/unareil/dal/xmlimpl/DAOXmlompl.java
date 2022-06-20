package eu.unareil.dal.xmlimpl;

import eu.unareil.bo.Pain;
import eu.unareil.dal.DALException;
import eu.unareil.dal.DAO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

public class DAOXmlompl implements DAO<Pain> {
    @Override
    public Pain selectById(int id) throws DALException {
        Node noeudEnfant;
        Pain pain=null;
        Document domXml;
        int idT=0;
        try {
            domXml = XmlTools.getConnection();
            Element root = domXml.getDocumentElement();
            NodeList enfantsRoot = root.getChildNodes();
            for(int i=0;i<=enfantsRoot.getLength();i++)
            {
                noeudEnfant=enfantsRoot.item(i);
                if(noeudEnfant instanceof Element){
                    if (((Element)noeudEnfant).getTagName().toUpperCase().equalsIgnoreCase("pain"))
                    {

                        Element elementIndividu = (Element)noeudEnfant;
                        NodeList enfantsIndividu = elementIndividu.getChildNodes();
                        for(int j=0;j<=enfantsIndividu.getLength();j++)
                        {
                            Node noeudEnfantIndiv = enfantsIndividu.item(j);
                            if(noeudEnfantIndiv instanceof Element){
                                Element element = (Element)noeudEnfantIndiv;
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("id"))
                                {
                                    idT= Integer.valueOf(element.getTextContent());
                                    if (idT==id)
                                    {
                                        pain = new Pain();
                                        pain.setRefProd(id);
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("libelle"))
                                {
                                    if (idT==id)
                                    {
                                        pain.setLibelle(element.getTextContent());
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("marque"))
                                {
                                    if (idT==id)
                                    {
                                        pain.setMarque(element.getTextContent());
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("poid"))
                                {
                                    if (idT==id)
                                    {
                                        pain.setPoids(Integer.parseInt(element.getTextContent()));
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("prix unitaire"))
                                {
                                    if (idT==id)
                                    {
                                        pain.setPrixUnitaire(Float.parseFloat(element.getTextContent()));
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("stock"))
                                {
                                    if (idT==id)
                                    {
                                        pain.setQteStock(Long.parseLong(element.getTextContent()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur SELECT_ALL",e);
        }
        return pain;
    }

    @Override
    public List<Pain> selectAll() throws DALException {
        Node noeudEnfant;
        List<Pain> pains = new ArrayList<>();
        Document domXml;
        try {
            domXml = XmlTools.getConnection();
            Element root = domXml.getDocumentElement();
            NodeList enfantsRoot = root.getChildNodes();
            for (int i = 0; i <= enfantsRoot.getLength(); i++) {
                noeudEnfant = enfantsRoot.item(i);
                if (noeudEnfant instanceof Element) {
                    if (((Element) noeudEnfant).getTagName().toUpperCase().equalsIgnoreCase("pain")) {
                        Pain pain = new Pain();
                        Element elementIndividu = (Element) noeudEnfant;
                        NodeList enfantsIndividu = elementIndividu.getChildNodes();
                        for (int j = 0; j <= enfantsIndividu.getLength(); j++) {
                            Node noeudEnfantIndiv = enfantsIndividu.item(j);
                            if (noeudEnfantIndiv instanceof Element) {
                                Element element = (Element) noeudEnfantIndiv;
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("id")) {
                                    int id = Integer.valueOf(element.getTextContent());
                                    pain.setRefProd(id);
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("libelle")) {
                                    pain.setLibelle(element.getTextContent());
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("marque")) {
                                    pain.setMarque(element.getTextContent());
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("poid")) {
                                    pain.setPoids(Integer.parseInt(element.getTextContent()));
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("prix unitaire")) {
                                    pain.setPrixUnitaire(Float.parseFloat(element.getTextContent()));
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("stock")) {
                                    pain.setQteStock(Long.parseLong(element.getTextContent()));
                                }
                            }
                        }
                        pains.add(pain);
                    }
                }
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur SELECT_ALL",e);
        }
        return pains;
    }

    @Override
    public void update(Pain data) throws DALException {
        Node noeudEnfant;
        @SuppressWarnings("unused")
        Pain pain=null;
        Document domXml;
        int idT=0;
        long id=data.getRefProd();
        try {
            domXml = XmlTools.getConnection();
            Element root = domXml.getDocumentElement();
            NodeList enfantsRoot = root.getChildNodes();
            for(int i=0;i<=enfantsRoot.getLength();i++)
            {
                noeudEnfant=enfantsRoot.item(i);
                if(noeudEnfant instanceof Element){
                    if (((Element)noeudEnfant).getTagName().toUpperCase().equalsIgnoreCase("pain"))
                    {

                        Element elementIndividu = (Element)noeudEnfant;
                        NodeList enfantsIndividu = elementIndividu.getChildNodes();
                        for(int j=0;j<=enfantsIndividu.getLength();j++)
                        {
                            Node noeudEnfantIndiv = enfantsIndividu.item(j);
                            if(noeudEnfantIndiv instanceof Element){
                                Element element = (Element)noeudEnfantIndiv;
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("id"))
                                {
                                    idT= Integer.parseInt(element.getTextContent());
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("libelle"))
                                {
                                    if (idT==id)
                                    {
                                        element.setTextContent(data.getLibelle());
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("marque"))
                                {
                                    if (idT==id)
                                    {
                                        element.setTextContent(data.getMarque());
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("poid"))
                                {
                                    if (idT==id)
                                    {
                                        element.setTextContent(String.valueOf(data.getPoids()));
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("prix unitaire"))
                                {
                                    if (idT==id)
                                    {
                                        element.setTextContent(String.valueOf(data.getPrixUnitaire()));
                                    }
                                }
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("stock"))
                                {
                                    if (idT==id)
                                    {
                                        element.setTextContent(String.valueOf(data.getQteStock()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //construire la transformation inactive
            Transformer t = TransformerFactory.newInstance().newTransformer();
            //définir les propriétés de sortie pour obtenir un nœud XSD
            //permet d'éviter d'afficher les balises sur la même ligne
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            // appliquer la transformation
            // chemin StreamResult sr = new StreamResult(new File("/my/file.xml"));
            StreamResult xmlStream = new StreamResult(Settings.getProperty("urlxml"));
            t.transform(new DOMSource(root), xmlStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur Update",e);
        }
    }

    @Override
    public int insert(Pain data) throws DALException {
        Node noeudEnfant;
        int nb=0;
        @SuppressWarnings("unused")
        List<Pain> stagiaires = new ArrayList<>();
        Document domXml;
        try {
            domXml = XmlTools.getConnection();
            Element root = domXml.getDocumentElement();
            NodeList enfantsRoot = root.getChildNodes();
            for(int i=0;i<=enfantsRoot.getLength();i++)
            {
                noeudEnfant=enfantsRoot.item(i);
                if(noeudEnfant instanceof Element){
                    if (((Element)noeudEnfant).getTagName().toUpperCase().equalsIgnoreCase("pain"))
                    {
                        nb++;
                    }
                }
            }
            nb++;
            //On crée un fichier xml correspondant au résultat
            Element pain = domXml.createElement("pain");
            Element id = domXml.createElement("id");
            id.setTextContent(String.valueOf(nb));
            pain.appendChild(id);
            Element libelle = domXml.createElement("libelle");
            libelle.setTextContent(data.getLibelle());
            pain.appendChild(libelle);
            Element marque = domXml.createElement("marque");
            marque.setTextContent(data.getMarque());
            pain.appendChild(marque);
            Element poid = domXml.createElement("poid");
            poid.setTextContent(String.valueOf(data.getPoids()));
            pain.appendChild(poid);
            Element prix_unitaire = domXml.createElement("prixUnitaire");
            prix_unitaire.setTextContent(String.valueOf(data.getPrixUnitaire()));
            pain.appendChild(prix_unitaire);
            Element stock = domXml.createElement("stock");
            stock.setTextContent(String.valueOf(data.getQteStock()));
            pain.appendChild(stock);
            Element durée_conservation = domXml.createElement("duréeConservation");
            durée_conservation.setTextContent(String.valueOf(data.getQteStock()));
            pain.appendChild(durée_conservation);
            root.appendChild(pain);
            //construire la transformation inactive
            Transformer t = TransformerFactory.newInstance().newTransformer();
            //définir les propriétés de sortie pour obtenir un nœud XSD
            //permet d'éviter d'afficher les balises sur la même ligne
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            // appliquer la transformation
            // chemin StreamResult sr = new StreamResult(new File("/my/file.xml"));
            StreamResult xmlStream = new StreamResult(Settings.getProperty("urlxml"));
            t.transform(new DOMSource(root), xmlStream);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur UPDATE",e);
        }
        return nb;
    }

    @Override
    public void delete(int id) throws DALException {
        Node noeudEnfant;
        @SuppressWarnings("unused")
        Pain pain=null;
        Document domXml;
        int idT=0;
        try {
            domXml = XmlTools.getConnection();
            Element root = domXml.getDocumentElement();
            NodeList enfantsRoot = root.getChildNodes();
            for(int i=0;i<=enfantsRoot.getLength();i++)
            {
                noeudEnfant=enfantsRoot.item(i);
                if(noeudEnfant instanceof Element){
                    if (((Element)noeudEnfant).getTagName().toUpperCase().equalsIgnoreCase("pain"))
                    {

                        Element elementIndividu = (Element)noeudEnfant;
                        NodeList enfantsIndividu = elementIndividu.getChildNodes();
                        for(int j=0;j<=enfantsIndividu.getLength();j++)
                        {
                            Node noeudEnfantIndiv = enfantsIndividu.item(j);
                            if(noeudEnfantIndiv instanceof Element){
                                Element element = (Element)noeudEnfantIndiv;
                                if (element.getTagName().toUpperCase().equalsIgnoreCase("id"))
                                {
                                    idT= Integer.valueOf(element.getTextContent());

                                }
                            }
                        }
                        if (id==idT)
                        {
                            root.removeChild(noeudEnfant);
                        }
                    }
                }
            }
            //construire la transformation inactive
            Transformer t = TransformerFactory.newInstance().newTransformer();
            //définir les propriétés de sortie pour obtenir un nœud XSD
            //permet d'éviter d'afficher les balises sur la même ligne
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            // appliquer la transformation
            // chemin StreamResult sr = new StreamResult(new File("/my/file.xml"));
            StreamResult xmlStream = new StreamResult(Settings.getProperty("urlxml"));
            t.transform(new DOMSource(root), xmlStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DALException("Erreur Update",e);
        }
    }
}
