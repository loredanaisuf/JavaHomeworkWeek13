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

    public void insertIntoAccomodation(String type, String bed_type, int max_guests, String description){
        try {
            PreparedStatement ps = conection.prepareStatement("INSERT INTO accomodation VALUES(nextval('sequence_acc'),?,?,?,?) ");
            ps.setString(1, type);
            ps.setString(2, bed_type);
            ps.setInt(3, max_guests);
            ps.setString(4, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdAccomodation(){
        int id=-1;
        try {
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM accomodation ");
            boolean hasResults = rs.next();
            if(hasResults){
                do{
                    id=rs.getInt("id");
                }while(rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void insertIntoRoomFair(float value, String season){
        try{
            PreparedStatement ps = conection.prepareStatement("INSERT INTO room_fair VALUES(nextval('sequence_room'),?,?)");
            ps.setFloat(1, value);
            ps.setString(2, season);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdRoom(){
        int id=-1;
        try {
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM room_fair ");
            boolean hasResults = rs.next();
            if(hasResults){
                do{
                    id=rs.getInt("id");
                }while(rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void insertIntoAccomodationFairRelation(int id_accomodation, int id_room_fair){
        try{
            PreparedStatement ps = conection.prepareStatement("INSERT INTO accomodation_fair_relation VALUES(nextval('sequence_relation'),?,?)");
            ps.setInt(1, id_accomodation);
            ps.setInt(2, id_room_fair);
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
