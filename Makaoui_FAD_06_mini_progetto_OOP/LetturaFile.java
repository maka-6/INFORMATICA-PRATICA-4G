package Makaoui_FAD_06_mini_progetto_OOP;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LetturaFile {

    public static List<String> leggiNomiDaFile(String filePath) throws IOException {
        List<String> nomi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) { // Evita righe vuote
                    nomi.add(linea.trim());
                }
            }
        }
        return nomi;
    }
}
