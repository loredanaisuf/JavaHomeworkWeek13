package ro.siit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.ResultSet;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Database database = new Database();

    @Test
    public void insertTest()
    {
        //int id_acc = sequence_acc.nextval;
        database.insertIntoAccomodation( "type", "double", 90, "description");
        int idAccomodation = database.getIdAccomodation();
        database.insertIntoRoomFair((float) 100, "s");
        int idRoom = database.getIdRoom();
        database.insertIntoAccomodationFairRelation(idAccomodation,idRoom);
    }


    @Test
    public void selectTest(){
        database.select();
    }
}
