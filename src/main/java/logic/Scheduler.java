package logic;

import lombok.SneakyThrows;
import model.Quote;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
//import java.util.stream.*;


public class Scheduler implements Serializable {

    @SneakyThrows
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects");
        List<File> existFiles = new ArrayList<>();

        while (true) {
            System.out.println("new iteration:");
            List<File> newFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles())));

            newFiles.stream().filter(file -> !existFiles.contains(file)).forEach(file -> QuoteConvert.readAndConvertQuote(file, existFiles));


            Thread.sleep(10000);
        }

    }

}
