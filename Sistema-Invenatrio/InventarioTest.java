import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    private Inventario inventario;

    @Before
    public void setUp() {
        inventario = new Inventario();
        inventario.registrar("Bebida 3L", 10);
    }

    @Test
    public void testSumarStock() {
        inventario.registrar("Bebida 3L", 5);
        Producto p = inventario.buscar("Bebida 3L");
        
        assertNotNull(p);
        assertEquals(15, p.getStock());
    }

    @Test
    public void testVentaExitosa() {
        inventario.vender("Bebida 3L", 4);
        Producto p = inventario.buscar("Bebida 3L");
        
        assertNotNull(p);
        assertEquals(6, p.getStock());
    }

    @Test
    public void testRechazarVentaInsuficiente() {
        inventario.vender("Bebida 3L", 15);
        Producto p = inventario.buscar("Bebida 3L");
        
        assertNotNull(p);
        assertEquals(10, p.getStock());
    }
}