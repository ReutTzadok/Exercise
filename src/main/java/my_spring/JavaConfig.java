package my_spring;

import lombok.Singular;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {

    @Singular
    private Map<Class,Class> ifc2ImplClass = new HashMap<>();
    private String packageToScan;

    public JavaConfig(String packageToScan) {
//        ifc2ImplClass.put(Speaker.class, SpeakerImpl.class);
        this.packageToScan = packageToScan;
    }

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {
        return ifc2ImplClass.get(type);
    }

    @Override
    public String getPackageToScan() { //todo
        return packageToScan;
    }
}








