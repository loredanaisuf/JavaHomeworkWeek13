package ro.siit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
        database.insertIntoAccomodation(100, "fndx", "double", 30, "fbdsbfdfdvsnnjdnf");
        database.insertIntoRoomFair(200, (float) 60.5, "hbjsmmd");
        database.insertIntoAccomodationFairRelation(500, 100,200);
    }


    @Test
    public void selectTest(){
        database.select();
    }
}
