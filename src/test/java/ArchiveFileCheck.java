import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ArchiveFileCheck {

    private ClassLoader cl = ArchiveFileCheck.class.getClassLoader();


    @BeforeAll
    static void preconditionSetup(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void reedAllRandomFileInArchiveTest() throws Exception {

        try (InputStream is = cl.getResourceAsStream("archive.zip"); ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry zipEntry ;
            while ((zipEntry = zis.getNextEntry()) != null){
                System.out.println(zipEntry.getName());
            }

        }


    }
}
