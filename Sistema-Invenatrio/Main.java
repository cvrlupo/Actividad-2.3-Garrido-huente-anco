import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inv = new Inventario();
        int opcion = 0;

        do {
            System.out.println("\n=== MENU ALMACEN ===");
            System.out.println("1. Registrar / Reponer producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Ver inventario");
            System.out.println("4. Ver stock critico (<= 5)");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el enter

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nomReg = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantReg = scanner.nextInt();
                    inv.registrar(nomReg, cantReg);
                    break;

                case 2:
                    System.out.print("Nombre del producto a vender: ");
                    String nomVen = scanner.nextLine();
                    System.out.print("Cantidad a vender: ");
                    int cantVen = scanner.nextInt();
                    inv.vender(nomVen, cantVen);
                    break;

                case 3:
                    inv.verInventario();
                    break;

                case 4:
                    inv.verStockCritico();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}