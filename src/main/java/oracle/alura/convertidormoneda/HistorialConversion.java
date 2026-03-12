package oracle.alura.convertidormoneda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversion {
    public static class Registro {
        public final String origen;
        public final String destino;
        public final double cantidad;
        public final double resultado;
        public final LocalDateTime fecha;
        public Registro(String origen, String destino, double cantidad, double resultado, LocalDateTime fecha) {
            this.origen = origen;
            this.destino = destino;
            this.cantidad = cantidad;
            this.resultado = resultado;
            this.fecha = fecha;
        }
    }
    private final List<Registro> historial = new ArrayList<>();
    public void agregar(String origen, String destino, double cantidad, double resultado) {
        historial.add(new Registro(origen, destino, cantidad, resultado, LocalDateTime.now()));
    }
    public List<Registro> obtenerHistorial() {
        return historial;
    }
}

