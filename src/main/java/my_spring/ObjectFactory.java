package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {

    private List<ObjectConfigurator> configurators = new ArrayList<>();

    //---------------------------------------------------------------------------

    @SneakyThrows
    ObjectFactory(ApplicationContext context) {
        Set<Class<? extends ObjectConfigurator>> classes = context.getScanner().getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes)
            if (!Modifier.isAbstract(aClass.getModifiers()))
                configurators.add(aClass.getDeclaredConstructor().newInstance());
    }

    //---------------------------------------------------------------------------

    @SneakyThrows
    public <T> T createAndConfigObject(Class<T> type) {
        T t = create(type);
        configure(t);
        return t;
    }

    //---------------------------------------------------------------------------

    private <T> T create(Class<T> type)
            throws InstantiationException, IllegalAccessException,
            java.lang.reflect.InvocationTargetException, NoSuchMethodException {

        T t = type.getDeclaredConstructor().newInstance();
        return t;
    }

    //---------------------------------------------------------------------------

    @SneakyThrows
    private <T> void configure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }

        Method[] methods = t.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RunThisMethode.class))
                method.invoke(t);
        }
    }
}
