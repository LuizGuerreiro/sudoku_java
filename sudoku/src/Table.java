import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Table {
    public static int maxRange = 9;
    private Cell[][] table = new Cell[9][9];

    public static GameStatusEnum statusGame = GameStatusEnum.NON_STARTED;

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
        String outPut = "\n \\-|-1-2-3-|-4-5-6-|-7-8-9-|-/\n";
        outPut = outPut + " -\\|=======================|/-\n";
        int auxiliar;
        for (int i = 0; i < maxRange; i++) {
            outPut = outPut + " " + (i+1) + "||";
            for (int j = 0; j < maxRange; j++) {
                auxiliar = table[i][j].getValue();
                outPut = outPut + " " + (auxiliar == 0 ? " " : auxiliar);
                if ((j+1)%3 == 0) {
                    outPut = outPut + " |";
                }
            }
            outPut = outPut + "|" + (i+1) + "\n";
            if ((i+1) == 3 || (i+1) == 6) {
                outPut = outPut + " -||-----------------------||-\n";
            }
        }
        outPut = outPut + " -/|=======================|\\-\n";
        outPut = outPut + " /-|-1-2-3-|-4-5-6-|-7-8-9-|-\\\n";
        return outPut;
    }

    public void insertValue(int line, int column, int value) {
        statusGame = GameStatusEnum.INCOMPLETE;
        table[line][column].setValue(value);
    }

    public void deleteValue(int line, int column) {
        table[line][column].setValue(0);
    }

    public void testTable() { 
        boolean complete = false;
        boolean result;

        complete = Verification.completeGame(table);
        if (complete) {
            statusGame = GameStatusEnum.COMPLETE;
        }
        result = Verification.lines(table) && Verification.columns(table) && Verification.groups(table);

        System.out.println(" =============================");
        System.out.println((result ? " || Nenhum erro encontrado! ||" : " ||    Jogo contém erro!    ||"));
        System.out.println((statusGame.getLabel()));
        System.out.println(" =============================");
        if (result && statusGame.equals(GameStatusEnum.COMPLETE)) {
            System.out.println(" =============================");
            System.out.println(" ||       PARABÉNS!!!       ||");
            System.out.println(" =============================");
        }
    }

    public void restart() {
        for (int i = 0; i < Table.maxRange; i++) {
            for (int j = 0; j < Table.maxRange; j++) {
                if(!table[i][j].getFixed()) {
                    table[i][j].setValue(0);
                }
            }
        }
        statusGame = GameStatusEnum.NON_STARTED;
        System.out.println(" Jogo reiniciado!");
    }
}