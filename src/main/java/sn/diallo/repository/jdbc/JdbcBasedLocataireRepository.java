package sn.diallo.repository.jdbc;

import sn.diallo.domain.*;
import sn.diallo.repository.LocataireRepository;
import sn.diallo.repository.jdbc.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedLocataireRepository implements LocataireRepository {
    private final DataSource dataSource;

    public JdbcBasedLocataireRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Locataire[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM locataire";
        //mapper le résultat
        List<Locataire> locataires = new ArrayList<Locataire>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                //mapping retour db (relationnel) avec objet Locataire
                Locataire locataire = new Locataire( id, nom, prenom, adresse, telephone, email);

                locataires.add(locataire);
            }
            return locataires.toArray(new Locataire[0]);

        }
        catch (SQLException e) {
            return new Locataire[0];
        }
        catch (Exception ex){
            return new Locataire[0];
        }

    }

    @Override
    public Locataire findById(int id) {
        String query = "SELECT * from locataire where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String retrievedNom = rs.getString("nom");
            String retrievedPrenom = rs.getString("prenom");
            String retrievedAdress = rs.getString("adresse");
            String retrievedTel = rs.getString("telephone");
            String retrievedEmail = rs.getString("email");
            Locataire locataire = new Locataire(retrievedId, retrievedNom, retrievedPrenom, retrievedAdress, retrievedTel, retrievedEmail);
            return locataire;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Locataire getByApart(Appartement appartement) {
        String query = "SELECT * from locataire where id_local = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, appartement.getId());
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String retrievedNom = rs.getString("nom");
            String retrievedPrenom = rs.getString("prenom");
            String retrievedAdress = rs.getString("adresse");
            String retrievedTel = rs.getString("telephone");
            String retrievedEmail = rs.getString("email");
            Locataire locataire = new Locataire(retrievedId, retrievedNom, retrievedPrenom, retrievedAdress, retrievedTel, retrievedEmail);
            return locataire;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
