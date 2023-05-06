package Function;

import java.util.ArrayList;
import java.util.Arrays;

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


}
