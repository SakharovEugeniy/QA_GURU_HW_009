import com.fasterxml.jackson.core.JsonProcessingException;
import model.Weapons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonFileCheck {

    @Test
    void jsonFileCheckTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/exampleJson.json");
        Weapons actualWeapons = objectMapper.readValue(file, Weapons.class);

        System.out.println(actualWeapons.getName());


    }
}
