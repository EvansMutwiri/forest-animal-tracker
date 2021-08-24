package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingsTest {
    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "moringa");
    }

    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sightings newSight = new Sightings(1,"Block A","jim");
        assertTrue(newSight instanceof Sightings);
    }

    @Test
    public void getLocation_sightingInstantiatesWithLocation(){
        Sightings newSight = new Sightings(1,"Block A","jim");
        assertEquals("Block A",newSight.getLocation());
    }
    @Test
    public void getRangerName_sightingInstantiatesWithRangerName(){
        Sightings newSight = new Sightings(1,"Block A","jim");
        assertEquals("jim",newSight.getRangerName());
    }
}