package logic;

import lombok.SneakyThrows;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FilesHandler {
    @SneakyThrows
    public static <T> void writeToFile(T object, String path, String fileName) {

        String filePath = path + fileName;

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(object);
        oos.close();
    }

    //-------------------------------------------------------------------------------------

    @SneakyThrows
    public static Object readFromFile(File file) {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }

    //-------------------------------------------------------------------------------------

    public static String createFileName() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        StringBuilder fileName = new StringBuilder(now.toString().replaceAll(":", "").replaceAll("-", ""));

        return String.valueOf(fileName);
    }
}
