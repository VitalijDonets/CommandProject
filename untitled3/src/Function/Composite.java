package Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Composite implements Function {
    private final ArrayList<Function> functions;
    public Composite() {
        this.functions = new ArrayList<>();
    }
    public Composite(Function... functions) {
        this.functions = new ArrayList<>(Arrays.asList(functions));
    }
    public Composite(ArrayList<Function> functions) {
        this.functions = functions;
    }
    public ArrayList<Function> getFunctions() {
        return functions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(functions, composite.functions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functions);
    }
}

