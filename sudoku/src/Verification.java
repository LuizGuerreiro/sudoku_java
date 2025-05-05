import java.util.HashSet;
import java.util.Set;

public class Verification {
    private static boolean test = true;
    private static int auxiliarValue;

    public static boolean lines(Cell[][] table) {
        for (int i = 0; i < Table.maxRange; i++) {
            Set<Integer> lineTest = new HashSet<>();
            for (int j = 0; j < Table.maxRange; j++) {
                auxiliarValue = table[i][j].getValue();
                if (auxiliarValue == 0) {
                    continue;
                }
                if (!lineTest.add(auxiliarValue)) {
                    System.out.printf("Valor %s repetido na %sa linha!\n", auxiliarValue, i+1);
                    test = false;
                }
            }
        }
        return test;
    }

    public static boolean columns(Cell[][] table) {
        for (int i = 0; i < Table.maxRange; i++) {
            Set<Integer> columnTest = new HashSet<>();
            for (int j = 0; j < Table.maxRange; j++) {
                auxiliarValue = table[j][i].getValue();
                if (auxiliarValue == 0) {
                    continue;
                }
                if (!columnTest.add(auxiliarValue)) {
                    System.out.printf("Valor %s repetido na %sa coluna!\n", auxiliarValue, i+1);
                    test = false;
                }
            }
        }
        return test;
    }

    public static boolean groups(Cell[][] table) {
        var lineInitial = 0;
        var columnInitial = 0;
        var lineRange = 3;
        var columnRange = 3;
        for (int group = 0; group < Table.maxRange; group++) {
            Set<Integer> groupTest = new HashSet<>();
            for (int line = lineInitial; line < lineRange; line++) {
                for (int column = columnInitial; column < columnRange; column++) {
                    auxiliarValue = table[line][column].getValue();
                    if (auxiliarValue == 0) {
                        continue;
                    }
                    if (!groupTest.add(auxiliarValue)) {
                        System.out.printf("Valor %s repetido no %so quadrante!\n", auxiliarValue, group+1);
                        test = false;
                    }
                }
            }
            if (group == 2 || group == 5) {
                lineInitial += 3;
                columnInitial = 0;
                lineRange += 3;
                columnRange = 3;
            } else {
                columnInitial += 3;
                columnRange += 3;
            }
        }
        return test;
    }
}
