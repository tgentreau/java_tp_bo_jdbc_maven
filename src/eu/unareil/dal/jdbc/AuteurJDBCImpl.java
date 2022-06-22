package eu.unareil.dal.jdbc;

import eu.unareil.bo.Auteur;
import eu.unareil.dal.DALException;
import eu.unareil.dal.DAO;
import eu.unareil.dal.jdbc.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurJDBCImpl implements DAO<Auteur> {
    private static final String SQL_INSERT = "insert into auteur (nomAuteur, prenomAuteur) values (?,?)";
    private static final String SQL_UPDATE = "update auteur set nomAuteur=?, prenomAuteur=? where idAuteur=?";
    private static final String SQL_DELETE = "delete from auteur where idAuteur=?";
    private static final String SQL_SELECT_ALL = "select * from auteur";
    private static final String SQL_SELECT_BY_ID = "select * from auteur where idAuteur=?";

    @Override
    public Auteur selectById(long id) throws DALException {
        ResultSet resultSet = null;
        Auteur auteur = null;
        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                auteur = new Auteur(resultSet.getLong(1),resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new DALException("erreur du select by id - id = " + id + e);
        }
        return auteur;
    }

    @Override
    public List<Auteur> selectAll() throws DALException {
        List<Auteur> auteurs = new ArrayList<>();
        Auteur auteur = null;
        try (Connection connection = JDBCTools.getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                auteur = new Auteur(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
                auteurs.add(auteur);
            }

        } catch (SQLException e) {
            throw new DALException("erreur du select all "+e);
        }
        return auteurs;
    }

    @Override
    public void update(Auteur data) throws DALException {
        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setString(1, data.getNom());
            preparedStatement.setString(2, data.getPrenom());
            preparedStatement.setLong(3, data.getId());
            int nbrRows = preparedStatement.executeUpdate();
            if(nbrRows != 0) {
                System.out.println("update effectué: " + nbrRows);
            }
        } catch (SQLException e) {
            throw new DALException("erreur du update - data="+data+ " " + e);
        }

    }

    @Override
    public void insert(Auteur data) throws DALException {
        try (Connection connection = JDBCTools.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, data.getNom());
            preparedStatement.setString(2, data.getPrenom());
            int nbrRows = preparedStatement.executeUpdate();
            if(nbrRows == 1) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if(rs.next()) {
                    data.setId(rs.getLong(1));
                    System.out.println("insert effectué: " + nbrRows);
                }
            }
        } catch (SQLException e) {
            throw new DALException("Erreur lors de l'insertion d'un auteur", e);
        }
    }

    @Override
    public void delete(Auteur data) throws DALException {
        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)){
            preparedStatement.setLong(1, data.getId());
            int nbrRows = preparedStatement.executeUpdate();
            if(nbrRows != 0) {
                System.out.println("delete effectué: " + nbrRows);
            }
        } catch (SQLException e) {
            throw new DALException("erreur du delete - data="+data+ " " + e);
        }
    }
}
