package my_spring;

import lombok.SneakyThrows;
import model.RandomObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class InjectRandomQuoteAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {

        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomQuote.class)) {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\quotes.txt"));
                List<String> quotes = reader.lines().map(String::toUpperCase).collect(Collectors.toList());

                field.setAccessible(true);
                field.set(t, RandomObject.getRandomItem(quotes));
            }

        }
    }


}
