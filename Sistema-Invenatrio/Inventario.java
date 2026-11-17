import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> lista;

    public Inventario() {
        lista = new ArrayList<>();
    }

    public Producto buscar(String nombre) {
        for (Producto p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void registrar(String nombre, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        Producto p = buscar(nombre);
        if (p != null) {
            p.setStock(p.getStock() + cantidad);
            System.out.println("El producto ya existía. Se sumaron " + cantidad + " unidades. Stock actual: " + p.getStock());
        } else {
            lista.add(new Producto(nombre, cantidad));
            System.out.println("Producto registrado con éxito.");
        }
    }

    public void vender(String nombre, int cantidad) {
        Producto p = buscar(nombre);

        if (p == null) {
            System.out.println("Error: El producto no existe.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad a vender debe ser mayor a 0.");
            return;
        }

        if (cantidad > p.getStock()) {
            System.out.println("¡Error! No hay suficiente stock. Solo quedan " + p.getStock() + " unidades.");
            return;
        }

        p.setStock(p.getStock() - cantidad);
        System.out.println("Venta realizada. Stock restante: " + p.getStock());
    }

    public void verInventario() {
        System.out.println("\n--- LISTA DE INVENTARIO ---");
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    public void verStockCritico() {
        System.out.println("\n--- REPORTE STOCK CRÍTICO (<= 5) ---");
        boolean hay = false;
        for (Producto p : lista) {
            if (p.getStock() <= 5) {
                System.out.println(p);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay productos con stock crítico.");
        }
    }
}