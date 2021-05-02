package logic;

import lombok.SneakyThrows;
import model.Quote;
import model.RandomObject;

import java.util.Arrays;
import java.util.List;

public class QuotesProducer {
    @SneakyThrows
    public static void main(String[] args) {
        //todo create an object with factory
        Quote quote = new Quote(RandomObject.getRandomItem(quotes));
        String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects\\";
        System.out.println(quote);

        FilesHandler.writeToFile(quote, path, FilesHandler.createFileName());
    }


    private static List<String> quotes = Arrays.asList("12345", "lsknf.kdnfsklzndfsldkflksjdhfkaj", "kldkjfhskfdfsf", "dfe");
}
