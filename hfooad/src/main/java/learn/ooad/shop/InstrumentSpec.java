package learn.ooad.shop;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {
    private final Map<String, Object> properties = new HashMap<>();

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public void setProperty(String name, Object value) {
        properties.put(name, value);
    }

    public boolean matches(InstrumentSpec other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        Map<String, Object> smallerProps = other.getProperties();
        Map<String, Object> biggerProps = properties;
        if (properties.size() < smallerProps.size()) {
            biggerProps = other.getProperties();
            smallerProps = properties;
        }
        for (Map.Entry<String, Object> me : smallerProps.entrySet()) {
            String key = me.getKey();
            Object value = me.getValue();
            Object v = biggerProps.get(key);
            if (!value.equals(v)) {
                 return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return properties.hashCode();
    }
}
