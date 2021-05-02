package my_spring;

import logic.FilesHandler;
import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Field;

public class InjectIdAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectId.class)) {
                String filePath = "C:\\Users\\User\\Desktop\\Big Data Course\\Big Data\\Exercise\\src\\main\\resources\\";
                String fileName = "idCounter.txt";

                File file = new File(filePath + fileName);

                Integer newId = (Integer) FilesHandler.readFromFile(file);
                FilesHandler.writeToFile(newId + 1, filePath, fileName);

                field.setAccessible(true);
                field.set(t, newId);
            }

        }
    }
}
