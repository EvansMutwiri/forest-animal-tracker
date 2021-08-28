//import org.junit.Rule;
//import org.junit.Test;
//
//
//
//import static org.junit.Assert.assertEquals;
//
//public class SightingTest {
//
//    Sight sightingAlpha = new Sight("zebra", "zone 1", "Eazy");
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void Sighting_instantiates_true() {
//        Sight testSighting = sightingAlpha;
//        assertEquals(true, testSighting instanceof Sight);
//    }
//
//    @Test
//    public void getName_returnsCorrectAnimalID_1() {
//        Sight testSighting = sightingAlpha;
//        assertEquals(0, testSighting.getId());
//    }
//
//    @Test
//    public void getRangerId_returnsCorrectRangerId_2() {
//        Sight testSighting = sightingAlpha;
//        assertEquals("Eaz", testSighting.getRanger());
//    }
//
//    @Test
//    public void getLocationId_returnsLocationId_2() {
//        Sight testSighting = sightingAlpha;
//        assertEquals("zone 1", testSighting.getSightLocation());
//    }
//}
//
