import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) throws Exception {
        
        final String initialArgs = "0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false";
        
        final String[] filteredArgs = initialArgs.split(" ");

        Table table = new Table(filteredArgs);

        Scanner scanner = new Scanner(System.in);
        var option = -1;

        do {
            System.out.println(">>>>>>>>>>> SUDOKU <<<<<<<<<<<");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Iniciar novo jogo");
            System.out.println("2 - Inserir número");
            System.out.println("3 - Apagar número");
            System.out.println("4 - Visualizar jogo");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                printError();
            }

            switch (option) {
                case 1: //Iniciar novo jogo
                    printTable(table);
                    option = -1;
                    break;
                case 2: //Inserir novo número
                    insertValue(scanner, table);
                    printTable(table);
                    option = -1;
                    break;
                case 3: //Apagar número
                    deleteValue(scanner, table);
                    printTable(table);
                    option = -1;
                    break;
                case 4: //Visualizar jogo
                    printTable(table);
                    option = -1;
                    break;
                case 5: //Verificar status do jogo
                    table.testTable();
                    option = -1;
                    break;
                case 0:
                    System.out.println(">>>>> Saindo do jogo... <<<<<");
                    break;
                default:
                    System.out.println("====== Opção inválida! ======");
                    break;
            }
        } while (option != 0);

        scanner.close();

        // table.insertValue(6, 1, 2);
        // table.insertValue(7, 0, 9);
        // table.insertValue(7, 0, 2);
        // table.insertValue(6, 1, 9);

        // System.out.println(table.toString());

        // table.testTable();

        //var temp = table.getValues();

        //System.out.printf((TableTemplate.TABLE_TEMPLATE) + "/n", temp.toString());
    }
    
    private static void insertValue(Scanner scanner, Table table) {
        var line = -1;
        var column = -1;
        var value = -1;

        System.out.print("Digite o número da linha (1-9): ");
        try {
            line = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            printError();
        }
        System.out.print("Digite o número da coluna (1-9): ");
        try {
            column = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            printError();
        }
        System.out.print("Digite o valor desejado (1-9): ");
        try {
            value = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            printError();
        }
        table.insertValue(--line, --column, value);
    }
    
    private static void deleteValue(Scanner scanner, Table table) {
        var line = -1;
        var column = -1;

        System.out.print("Digite o número da linha (1-9): ");
        try {
            line = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            printError();
        }
        System.out.print("Digite o número da coluna (1-9): ");
        try {
            column = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            printError();
        }
        table.deleteValue(--line, --column);
    }

    public static void printTable(Table table) {
        System.out.println(table.toString());
    }

    private static void printError() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Deve ser informado um número!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}