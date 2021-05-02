package logic;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class JsonMapper {
    @SneakyThrows
    public static String convertToJson(Object object) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append(fieldToString(fields[i], object) + ", ");
        }

        json.delete(json.length() - 2, json.length());
        json.append("}");

        String s = String.valueOf(json);
        return s;
    }

    @SneakyThrows
    private static String fieldToString(Field f, Object o) {
        String s = "\"" + f.getName() + "\": ";

        s += f.getType().equals(String.class) ? "\"" + f.get(o) + "\"" : f.get(o);

        return s;
    }
}
