package oracle.alura.convertidormoneda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConvertidorMonedaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testConversionUSDToARS() throws Exception {
        ConversorService service = new ConversorService();
        double tasa = service.obtenerTasaConversion("USD", "ARS");
        assert tasa > 0;
    }

    @Test
    void testHistorialConversion() {
        HistorialConversion historial = new HistorialConversion();
        historial.agregar("USD", "ARS", 10, 1000);
        assert historial.obtenerHistorial().size() == 1;
    }
}
