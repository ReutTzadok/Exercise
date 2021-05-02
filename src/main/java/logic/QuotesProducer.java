package logic;

import lombok.SneakyThrows;
import model.Quote;
import my_spring.ApplicationContext;

public class QuotesProducer {
    @SneakyThrows
    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext("my_spring");
        Quote quote = context.getObject(Quote.class);

        String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Objects\\";
        System.out.println(quote);

        FilesHandler.writeToFile(quote, path, FilesHandler.createFileName());
    }
}
