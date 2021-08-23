package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "moringa");
    }


    @Test
    public void animal_instantiatesCorrectly_true() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertEquals(true, testAnimal instanceof EndangeredAnimal);
    }
    @Test
    public void getName_animalInstantiatesWithName() {
        Animal testAnimal = new EndangeredAnimal("Rhino",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertEquals("Rhino", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame() {
        EndangeredAnimal firstAnimal = new EndangeredAnimal("Rhino",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        EndangeredAnimal anotherAnimal = new EndangeredAnimal("Rhino",EndangeredAnimal.ILL,EndangeredAnimal.ADULT);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String sqlAnimal = "DELETE FROM animals *;";
            con.createQuery(sqlAnimal).executeUpdate();
        }
    }
}
