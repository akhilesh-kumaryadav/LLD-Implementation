package InterpreterPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Integer> variables = new HashMap<>();

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        return variables.getOrDefault(name, 0);
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}