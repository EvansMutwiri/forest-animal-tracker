import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class SightingTest {

    Sight sightingAlpha = new Sight("zebra", "zone 1", "nel");
    Sight sightingBravo = new Sight("zebra", "zone 1", "nel");

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sighting_instantiates_true() {
        Sight testSighting = sightingAlpha;
        assertEquals(true, testSighting instanceof Sight);
    }

    @Test
    public void getName_returnsCorrectAnimalID_1() {
        Sight testSighting = sightingAlpha;
        assertEquals(0, testSighting.getId());
    }

    @Test
    public void getRangerId_returnsCorrectRangerId_2() {
        Sight testSighting = sightingAlpha;
        assertEquals("nel", testSighting.getRanger());
    }

    @Test
    public void getLocationId_returnsLocationId_2() {
        Sight testSighting = sightingAlpha;
        assertEquals("zone 1", testSighting.getSightLocation());
    }



}

