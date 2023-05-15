package jointClass;

import Function.*;

public class SaveFunctions {
    public Function currentFunction = Abs.of(Linear.X);
    public Function currentFunctionDX = null;
    public String[] functions = {"|x|", "cos(x)", "e^x", "x", "x^2", "sin(x)"};
}
