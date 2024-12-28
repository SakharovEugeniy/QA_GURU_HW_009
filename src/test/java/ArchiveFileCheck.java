import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
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


                if(zipEntry.getName().endsWith(".pdf")){
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals("Проверочная строка для pdf файла. \r\n", pdf.text);
                }

                if(zipEntry.getName().endsWith(".xlsx")){
                    XLS xls = new XLS(zis);
                    //xls.excel.getSheetAt(0).getRow(1).getCell(1);



                }



            }
            

        }


    }
}
