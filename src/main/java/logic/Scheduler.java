package logic;

import lombok.SneakyThrows;
import model.Quote;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Scheduler implements Serializable {
    @SneakyThrows
    public static void main(String[] args) {
//        File sourceDirectory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects");
        File directory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects");
//        File destinationDirectory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Jsons");
//        List<File> existFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(destinationDirectory.listFiles())));
        List<File> existFiles = new ArrayList<>();
        String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Jsons\\";

        while (true) {
            System.out.println("new iteration:");
            List<File> newFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles())));

            //todo fix the condition
//            if (!contain(existFiles, newFiles)) {
            if (existFiles.size() < newFiles.size()) {
                System.out.println("new files");
                newFiles.removeAll(existFiles);

                for (File file : newFiles) {
                    Quote quote = (Quote) FilesHandler.readFromFile(file);

                    //todo move to thread
                    String json = JsonMapper.convertToJson(quote);
                    FilesHandler.writeToFile(json, path, file.getName());
                }

                existFiles.addAll(newFiles);
            }


            Thread.sleep(10000);
        }
    }

    //return true if l1 contain l2
    private static <T> boolean contain(List<T> l1, List<T> l2) {
        for (T t : l2) {
            if (!l1.contains(t))
                return false;
        }

        return true;
    }
}
