package logic;

import model.Quote;

import java.io.File;
import java.util.List;

public class QuoteConvert {

    private static final String path = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\Files\\Jsons\\";

    public static void readAndConvertQuote(File file, List<File> existFiles) {
        Quote quote = (Quote) FilesHandler.readFromFile(file);

        String json = JsonMapper.convertToJson(quote);
        File jsonFile = FilesHandler.writeToFile(json, path, file.getName());

        existFiles.add(jsonFile);
    }
}
