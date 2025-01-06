import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ArchiveFileCheck {

    private ClassLoader cl = ArchiveFileCheck.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержания файлов разного расширения внутри zip архива")
    public void reedAllRandomFileInArchiveTest() throws Exception {

        try (InputStream is = cl.getResourceAsStream("archive.zip"); ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {


                if (zipEntry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals("Проверочная строка для pdf файла. \r\n", pdf.text);
                }

                if (zipEntry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    String actualResult1 = xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
                    String actualResult2 = xls.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue();
                    Assertions.assertEquals("Проверка строки в xl файле", actualResult1);
                    Assertions.assertEquals("проверка ещё одной строки в xl файле", actualResult2);
                }

                if (zipEntry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = csvReader.readAll();
                    Assertions.assertEquals(2, data.size());
                    Assertions.assertArrayEquals(new String[]{"Строки", " для"}, data.get(0));
                    Assertions.assertArrayEquals(new String[]{"проверки", " csv afqkf"}, data.get(1));
                }
            }
        }
    }
}
