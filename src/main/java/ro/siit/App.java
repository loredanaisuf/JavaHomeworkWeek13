package ro.siit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Database database = new Database();
        //database.insertIntoAccomodation(2, "pension", "double", 30, "fbdsbfdfdvsnnjdnf");
//        database.insertIntoRoomFair(20, (float) 60.5, "hbjsmmd");
//        database.insertIntoAccomodationFairRelation(1, 1,10);
//        database.insertIntoAccomodationFairRelation(2,2,20);
        database.insertIntoAccomodationFairRelation(3,1,20);
    }
}
