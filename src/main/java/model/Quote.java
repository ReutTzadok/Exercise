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
        String filePath = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\";
        String fileName = "idCounter.txt";

        File file = new File(filePath + fileName);

        Integer newId = (Integer) FilesHandler.readFromFile(file);
        FilesHandler.writeToFile(newId + 1, filePath, fileName);

        return newId;
    }
}
