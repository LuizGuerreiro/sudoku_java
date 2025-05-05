public class Cell {
    private final boolean fixed;
    private final int expected;
    private int value;
    private int[] pencil;

    public Cell(boolean fixed, int expected) {
        this.fixed = fixed;
        this.expected = expected;
        if (fixed) {
            this.value = expected;
        } else {
            this.value = 0;
            this.pencil = new int[Table.maxRange];
        }
    }

    public void setValue(int value) {
        if (fixed) {
            System.out.println("Célula fixa!");
        } else {
            this.value = value;
            this.pencil = null;
        }
    }

    public void setPencil(int value) {
        if (fixed) {
            System.out.println("Célula fixa!");
        } else {
            this.pencil[value-1] = value;
        }
    }

    public boolean getFixed() {
        return fixed;
    }

    public int getExpected() {
        return expected;
    }

    public int getValue() {
        return value;
    }

    public int[] getPencil() {
        return pencil;
    }
}
