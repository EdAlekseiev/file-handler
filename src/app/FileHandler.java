package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";
    private final static String FILE_EXTENSION = ".txt";

    public String writeFile(String fileName, String fileContent) {
        String pathToFile = String.format("%s%s%s", BASE_PATH, fileName, FILE_EXTENSION);
        try (FileWriter fw = new FileWriter(pathToFile)) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
