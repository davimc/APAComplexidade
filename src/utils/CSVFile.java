package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVFile {
    public void saveCsv(String infos) throws IOException {
        String path = "./algorithms.csv";
        try (FileWriter fw = new FileWriter(path, true); // 'true' ativa o modo append
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println((infos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
