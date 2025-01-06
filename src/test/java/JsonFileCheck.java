import com.fasterxml.jackson.core.JsonProcessingException;
import model.Weapons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonFileCheck {

    private ClassLoader cl = JsonFileCheck.class.getClassLoader();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonFileCheckTest() throws Exception {

        try(InputStream is = cl.getResourceAsStream("exampleJson.json"); Reader reader = new InputStreamReader(is)){

            Weapons actualWeapons = objectMapper.readValue(reader, Weapons.class);
            System.out.println(actualWeapons.getName());
        }



        


    }
}
