package ro.siit;

import java.sql.*;

public class Database {

    private Connection conection;
    public Database(){
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/siit10?user=postgres&password=Loredana12";
            this.conection= DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoAccomodation(int id, String type, String bed_type, int max_guests, String description){
        try {
            PreparedStatement ps = conection.prepareStatement("INSERT INTO accomodation(id, type, bed_type, max_guests, description) VALUES(?,?,?,?,?) ");
            ps.setInt(1, id);
            ps.setString(2, type);
            ps.setString(3, bed_type);
            ps.setInt(4, max_guests);
            ps.setString(5, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoRoomFair(int id, float value, String season){
        try{
            PreparedStatement ps = conection.prepareStatement("INSERT INTO room_fair(id, value, season) VALUES(?,?,?)");
            ps.setInt(1, id);
            ps.setFloat(2, value);
            ps.setString(3, season);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoAccomodationFairRelation(int id, int id_accomodation, int id_room_fair){
        try{
            PreparedStatement ps = conection.prepareStatement("INSERT INTO accomodation_fair_relation(id, id_accomodation, id_room_fair) VALUES(?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, id_accomodation);
            ps.setInt(3, id_room_fair);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(){
        final String format = "%20s%20s\n";
        try {
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery("SELECT acc.id, r.value FROM accomodation acc join accomodation_fair_relation ON acc.id = accomodation_fair_relation.id_accomodation join room_fair r ON accomodation_fair_relation.id_room_fair = r.id");
            System.out.format(format, "Room", "Value");
            while(rs.next()){
                System.out.format(format, rs.getString("id"), rs.getDouble("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
