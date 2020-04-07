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
    public void insertIntoAccomodationTest()
    {
        database.insertIntoAccomodation(3, "fndx", "double", 30, "fbdsbfdfdvsnnjdnf");
    }

    @Test
    public void insertIntoRoomFairTest(){
        database.insertIntoRoomFair(30, (float) 60.5, "hbjsmmd");
    }

    @Test
    public void insertIntoAccomodationFairRelationTest(){
        database.insertIntoAccomodationFairRelation(5, 3,30);
    }

    @Test
    public void selectTest(){
        database.select();
    }
}
