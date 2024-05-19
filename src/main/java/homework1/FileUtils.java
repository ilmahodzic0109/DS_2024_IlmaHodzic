package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            for (int i = 1; i < lines.size(); i++) {
                String[] value = lines.get(i).split(";");
                Entry entry = new Entry();

                entry.setFullName(value[0]);
                entry.setStreetAddress(value[1]);
                entry.setCity(value[2]);
                entry.setPostcode(value[3]);
                entry.setCountry(value[4]);
                entry.setPhoneNumber(value[5]);

                entries.add(entry);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Entry entry : entries) {
                writer.write(entry.getFullName() + ";"
                        + entry.getStreetAddress() + ";"
                        + entry.getCity() + ";"
                        + entry.getPostcode() + ";"
                        + entry.getCountry() + ";"
                        + entry.getPhoneNumber() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}