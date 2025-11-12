package co.com.scheduler.model.outfit;

import static org.junit.jupiter.api.Assertions.*;

import co.com.scheduler.model.outfit.model.Outfit;
import org.junit.jupiter.api.Test;
import java.util.UUID;


public class OutfitTest {

    @Test
    void shouldCreateOutfitWhenDataIsValid() {
        UUID id = UUID.randomUUID();
        String name = "Black coat with white boots";
        Outfit outfit = new Outfit.Builder()
                .withId(id)
                .withName(name)
                .build();
        assertAll("Outfit creation",
                () -> assertNotNull(outfit, "Outfit instance should not be null"),
                () -> assertEquals(id, outfit.getId(), "ID should match the provided one"),
                () -> assertEquals(name, outfit.getName(), "Name should match the provided one")
        );
    }
    @Test
    void shouldNotCreateOutfitWhenDataIsInvalid() throws IllegalArgumentException {
        UUID id = null;
        String name = " ";
        assertThrows(IllegalArgumentException.class,
                () -> new Outfit.Builder().withId(id).withName(name).build(),
                "Should not create outfit with invalid ID and name empty");
    }
}
