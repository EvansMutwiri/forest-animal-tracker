import models.EndangeredAnimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EndangeredAnimalTest {

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void getId_endangeredAnimalInstantiatesWithEndangeredAnimalId_int() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        assertEquals(0, testEndangeredAnimal.getEndangeredAnimalId());
    }

    @Test
    public void equals_returnsTrueIfNameAndEndangeredAnimalIdAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
    }

    @Test
    public void Save_returnsTrueIfDescriptionsAretheSame() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getEndangeredAnimalId(), testEndangeredAnimal.getEndangeredAnimalId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("gir", "adult","ill", "zone A", "SiR");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("bubbles", "adult","ill", "zone B", "SiR");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
}