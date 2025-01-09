import com.fasterxml.jackson.databind.ObjectMapper;
import model.Weapons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class JsonFileCheck {

    private ClassLoader cl = JsonFileCheck.class.getClassLoader();
    private ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("Тест на проверку значений всех полей JSON файла")
    @Test
    void jsonFileCheckTest() throws Exception {

        try (InputStream is = cl.getResourceAsStream("exampleJson.json"); Reader reader = new InputStreamReader(is)) {

            Weapons actualWeapons = objectMapper.readValue(reader, Weapons.class);
            Assertions.assertEquals("bastard sword", actualWeapons.getName());
            Assertions.assertEquals(123456, actualWeapons.getId());
            Assertions.assertEquals("EPIC", actualWeapons.getWeaponsType());
            Assertions.assertEquals(0.016, actualWeapons.getChanceToDrop());
            Assertions.assertEquals(15, actualWeapons.getCharactersWeapon().getDamageMin());
            Assertions.assertEquals(25, actualWeapons.getCharactersWeapon().getDamageMax());
            Assertions.assertEquals(0.25, actualWeapons.getCharactersWeapon().getCriticalChance());
        }
    }
}
