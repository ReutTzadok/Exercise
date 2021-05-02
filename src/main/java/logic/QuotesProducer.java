package logic;

import lombok.SneakyThrows;
import model.Quote;
import model.RandomObject;
import my_spring.ApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuotesProducer {
    @SneakyThrows
    public static void main(String[] args) {
        //todo create an object with factory

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\quotes.txt"));
        List<String> quotes = reader.lines().map(String::toUpperCase).collect(Collectors.toList());
        //--------------------------------
        ApplicationContext context = new ApplicationContext("my_spring");

        //--------------------------------

        Quote quote = new Quote(RandomObject.getRandomItem(quotes));
        String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects\\";
        System.out.println(quote);

        FilesHandler.writeToFile(quote, path, FilesHandler.createFileName());
    }
}
