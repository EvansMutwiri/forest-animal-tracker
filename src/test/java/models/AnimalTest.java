package models;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "moringa");
    }

    @Test
    public void animal_InstanceOfAnimal_true() {
        Animal testAnimal = new Animal("Giro");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName() {
        Animal testAnimal = new Animal("Giro");
        assertEquals("Giro", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame() {
        Animal firstAnimal = new Animal("Henry");
        Animal anotherAnimal = new Animal("Henry");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @After
    public void tearDown() throws Exception {
        try (Connection con = DB.sql2o.open()) {
            String animal = "DELETE FROM animals *;";
            con.createQuery(animal).executeUpdate();
        }
    }
}