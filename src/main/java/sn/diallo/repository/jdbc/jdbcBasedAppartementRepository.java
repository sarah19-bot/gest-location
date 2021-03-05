package sn.diallo.repository.jdbc;

import sn.diallo.domain.*;
import sn.diallo.repository.AppartementRepository;
import sn.diallo.repository.jdbc.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcBasedAppartementRepository implements AppartementRepository {
    private final DataSource dataSource;

    public jdbcBasedAppartementRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Appartement[] getAllByProprietaire(Proprietaire proprietaire) {
        String query = "SELECT * from appartement where proprietaire = ?";
        //mapper le résultat
        List<Appartement> appartements = new ArrayList<Appartement>();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, proprietaire.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int retrievedId = rs.getInt("id");
                String type1 = rs.getString("type");
                Type retrievedType = Type.T1;
                for (Type t: Type.values()) {
                    if (t.equals(type1)){
                        retrievedType = t;
                    }
                }
                String retrievedSuperficie = rs.getString("superficie");
                String retrievedAdress = rs.getString("adresse");
                int p = rs.getInt("proprietaire");
                JdbcProprietaireRepository jdbcpr = new JdbcProprietaireRepository(dataSource);
                Proprietaire retrievedProp = jdbcpr.findById(p);
                long retrievedPrix = rs.getLong("prix");
                Appartement appartement =  new Appartement(retrievedId, retrievedType, retrievedSuperficie, retrievedAdress, retrievedProp, retrievedPrix);

                appartements.add(appartement);
            }
            return appartements.toArray(new Appartement[0]);
        }catch (SQLException e) {
            return new Appartement[0];
        }
        catch (Exception ex){
            return new Appartement[0];
        }
    }

    @Override
    public Appartement[] getAllByLocataire(Locataire locataire) {

        String query = "SELECT appartement.id, type, superficie, appartement.adresse, proprietaire, prix from locataire INNER JOIN appartement ON locataire.id_local = ? AND locataire.id_local = appartement.id";
        //mapper le résultat
        List<Appartement> appartements = new ArrayList<Appartement>();
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, locataire.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int retrievedId = rs.getInt("id");
                String type1 = rs.getString("type");
                Type retrievedType = Type.T1;
                for (Type t: Type.values()) {
                    if (t.equals(type1)){
                        retrievedType = t;
                    }
                }
                String retrievedSuperficie = rs.getString("superficie");
                String retrievedAdress = rs.getString("adresse");
                int p = rs.getInt("proprietaire");
                JdbcProprietaireRepository jdbcpr = new JdbcProprietaireRepository(dataSource);
                Proprietaire retrievedProp = jdbcpr.findById(p);
                long retrievedPrix = rs.getLong("prix");
                Appartement appartement =  new Appartement(retrievedId, retrievedType, retrievedSuperficie, retrievedAdress, retrievedProp, retrievedPrix);
                appartements.add(appartement);
            }
            return appartements.toArray(new Appartement[0]);
        }catch (SQLException e) {
            return new Appartement[0];
        }
        catch (Exception ex){
            return new Appartement[0];
        }
    }

    public Appartement[] getAll()  {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM appartement";
        //mapper le résultat
        List<Appartement> appartements = new ArrayList<Appartement>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String type1 = rs.getString("type");
                Type type = Type.T1;
                for (Type t: Type.values()) {
                    if (t.equals(type1)){
                        type = t;
                    }
                }
                String superficie = rs.getString("superficie");
                String adresse = rs.getString("adresse");
                int p = rs.getInt("proprietaire");
                JdbcProprietaireRepository jdbcpr = new JdbcProprietaireRepository(dataSource);
                Proprietaire proprietaire = jdbcpr.findById(p);
                long prix = rs.getLong("prix");
                //mapping retour db (relationnel) avec objet Appartement
                Appartement appartement = new Appartement( id, type, superficie, adresse, proprietaire, prix);

                appartements.add(appartement);
            }
            return appartements.toArray(new Appartement[0]);

        }
        catch (SQLException e) {
            return new Appartement[0];
        }
        catch (Exception ex){
            return new Appartement[0];
        }

    }

    public Appartement findById(int id) {
        String query = "SELECT * from appartement where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int retrievedId = rs.getInt("id");
            String type1 = rs.getString("type");
            Type retrievedType = Type.T1;
            for (Type t: Type.values()) {
                if (t.equals(type1)){
                    retrievedType = t;
                }
            }
            String retrievedSuperficie = rs.getString("superficie");
            String retrievedAdress = rs.getString("adresse");
            int p = rs.getInt("proprietaire");
            JdbcProprietaireRepository jdbcpr = new JdbcProprietaireRepository(dataSource);
            Proprietaire retrievedProp = jdbcpr.findById(p);
            long retrievedPrix = rs.getLong("prix");
            return new Appartement(retrievedId, retrievedType, retrievedSuperficie, retrievedAdress, retrievedProp, retrievedPrix);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
