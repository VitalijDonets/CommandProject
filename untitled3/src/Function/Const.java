package Function;

import java.text.NumberFormat;

public class Const extends Number implements Function{
    public static final Const NULL = new Const(0);
    private final double value;
    public static Const of(double value) {
        return new Const(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return Double.compare(aConst.value, value) == 0;
    }

    public Const(double value) {
        this.value = value;
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public double calculate(double x) {
        return value;
    }

    @Override
    public Function dx() {
        return NULL;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return nf.format(value);
    }
}
