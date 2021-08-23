import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangerTest {

    @Test
    public void ranger_instantiatesCorrectly_true() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        assertEquals(true, testRanger instanceof Ranger);
    }

    @Test
    public void getId_rangerInstantiatesWithRangerId_int() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        assertEquals(1, testRanger.getRangerId());
    }

    @Test
    public void equals_returnsTrueIfNameAndRangerIdAreSame_true() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        Ranger anotherRanger = new Ranger(1, "Bubbles");
        assertTrue(testRanger.equals(anotherRanger));
    }

    @Test
    public void Save_returnsTrueIfDescriptionsAretheSame() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        testRanger.save();
        assertTrue(Ranger.all().get(0).equals(testRanger));
    }

    @Test
    public void save_assignsIdToRanger() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        testRanger.save();
        Ranger savedRanger = Ranger.all().get(0);
        assertEquals(savedRanger.getRangerId(), testRanger.getRangerId());
    }

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger firstRanger = new Ranger(1, "Bubbles");
        firstRanger.save();
        Ranger secondRanger = new Ranger(1, "Spud");
        secondRanger.save();
        assertEquals(true, Ranger.all().get(0).equals(firstRanger));
        assertEquals(true, Ranger.all().get(1).equals(secondRanger));
    }
    

    //One-to-Many Relationship

    @Test
    public void save_recordsTimeOfCreationInDatabase() {
        Ranger testRanger = new Ranger(1, "Bubbles");
        testRanger.save();
        Timestamp savedRangerTime = Ranger.find(testRanger.getRangerId()).getRecordTime();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getTime(), savedRangerTime.getTime());
    }
}