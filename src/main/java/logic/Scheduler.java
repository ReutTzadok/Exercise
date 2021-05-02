package logic;

import lombok.SneakyThrows;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Scheduler implements Serializable {

    @SneakyThrows
    public static void main(String[] args) {
        File sourceDirectory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects");
        File destinationDirectory = new File("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Jsons");
        List<File> existFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(destinationDirectory.listFiles())));

        while (true) {
            List<File> newFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(sourceDirectory.listFiles())));

            newFiles.parallelStream()
                    .filter(file -> !existFiles.stream().map(File::getName).collect(Collectors.toList()).contains(file.getName())).
                    forEach(file -> QuoteConvert.readAndConvertQuote(file, existFiles));


            Thread.sleep(10000);
        }

    }

}
