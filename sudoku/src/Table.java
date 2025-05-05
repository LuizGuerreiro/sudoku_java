import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Table {
    public static int maxRange = 9;
    private Cell[][] table = new Cell[9][9];

    public Table(String[] initialArgs) {
        final var args = Stream.of(initialArgs)
            .collect(Collectors.toMap(
                key -> key.split(";")[0],
                value -> value.split(";")[1]
            ));

        for (int i = 0; i < maxRange; i++) {
            for (int j = 0; j < maxRange; j++) {
                var cellValues = args.get("%s,%s".formatted(i,j));
                var expected = Integer.parseInt(cellValues.split(",")[0]);
                var fixed = Boolean.parseBoolean(cellValues.split(",")[1]);
                table[i][j] = new Cell(fixed, expected);
            }
        }
    }

    public String toString() {
        String outPut = "\n*-*-*-*-*-*-*-*-*-*-*-*-*\n";
        int auxiliar;
        for (int i = 0; i < maxRange; i++) {
            outPut = outPut + "|";
            for (int j = 0; j < maxRange; j++) {
                auxiliar = table[i][j].getValue();
                outPut = outPut + " " + (auxiliar == 0 ? " " : auxiliar);
                if ((j+1)%3 == 0) {
                    outPut = outPut + " |";
                }
            }
            outPut = outPut + "\n";
            if ((i+1)%3 == 0) {
                outPut = outPut + "-------------------------\n";
            }
        }
        return outPut;
    }

    public void insertValue(int line, int column, int value) {
        table[line][column].setValue(value);
    }

    public void deleteValue(int line, int column) {
        table[line][column].setValue(0);
    }

    public void testTable() { // IMPLEMENTAR GAME STATUS
        boolean result;
        result = Verification.lines(table);
        result = Verification.columns(table);
        result = Verification.groups(table);

        System.out.println((result ? "Nenhum erro encontrado!" : "Jogo contém erro!"));
    }

    /*public Integer[] getValues() {
        Integer[] values = new Integer[81];
        for (int i = 0; i < maxRange; i++) {
            for (int j = 0; j < maxRange; j++) {
                values[(i*10)+j] = table[i][j].getValue();
            }
        }

        return values;
    }*/
}