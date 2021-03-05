package sn.diallo.repository.jdbc;

import sn.diallo.domain.*;
import sn.diallo.repository.ProprietaireRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProprietaireRepository implements ProprietaireRepository {

    private final DataSource dataSource;

    public JdbcProprietaireRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Proprietaire[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM proprietaire";
        //mapper le résultat
        List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
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
                //mapping retour db (relationnel) avec objet Proprietaire
                Proprietaire proprietaire = new Proprietaire( id, nom, prenom, adresse, telephone, email);

                proprietaires.add(proprietaire);
            }
            return proprietaires.toArray(new Proprietaire[0]);

        }
        catch (SQLException e) {
            return new Proprietaire[0];
        }
        catch (Exception ex){
            return new Proprietaire[0];
        }

    }

    @Override
    public Proprietaire findById(int id) {
        String query = "SELECT * from proprietaire where id = ?";
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
            Proprietaire proprietaire = new Proprietaire(retrievedId, retrievedNom, retrievedPrenom, retrievedAdress, retrievedTel, retrievedEmail);
            return proprietaire;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Proprietaire getByAppart(Appartement appartement) {
        String query = "SELECT proprietaire.id, nom, prenom, proprietaire.adresse, telephone, email from proprietaire INNER JOIN appartement ON appartement.id = ?";
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
            Proprietaire proprietaire = new Proprietaire(retrievedId, retrievedNom, retrievedPrenom, retrievedAdress, retrievedTel, retrievedEmail);
            return proprietaire;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
