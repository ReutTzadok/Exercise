package model;


import logic.FilesHandler;
import lombok.SneakyThrows;

import java.io.File;
import java.io.Serializable;

public class Quote implements Serializable {
    private int id;
    private String quote;
    private QuoteLength length;

    public Quote(String quote) {
        this.id = createNewId();
        this.quote = quote;
        this.length = QuoteLength.findQuoteLength(quote);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", length=" + length +
                '}';
    }

    @SneakyThrows
    private int createNewId() {
        String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\idCounter.txt";
        File file = new File(path);
        Integer newId = (Integer) FilesHandler.readFromFile(file);
        FilesHandler.writeToFile(newId + 1, "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\", "idCounter.txt");
        return newId;
    }
}
