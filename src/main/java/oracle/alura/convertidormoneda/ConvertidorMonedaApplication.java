package oracle.alura.convertidormoneda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConvertidorMonedaApplication {

    public static void main(String[] args) {
        ConversorService conversor = new ConversorService();
        HistorialConversion historial = new HistorialConversion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sea bienvenido/a al Conversor de Moneda");
        while (true) {
            System.out.println("\nSeleccione la moneda de origen:");
            int i = 1;
            for (String moneda : conversor.getSupportedCurrencies()) {
                System.out.println(i + ". " + moneda);
                i++;
            }
            System.out.println("0. Salir");
            int opcionOrigen = scanner.nextInt();
            if (opcionOrigen == 0) break;
            String[] monedas = conversor.getSupportedCurrencies().toArray(new String[0]);
            if (opcionOrigen < 1 || opcionOrigen > monedas.length) {
                System.out.println("Opción inválida");
                continue;
            }
            String origen = monedas[opcionOrigen - 1];
            System.out.println("Seleccione la moneda de destino:");
            i = 1;
            for (String moneda : conversor.getSupportedCurrencies()) {
                System.out.println(i + ". " + moneda);
                i++;
            }
            int opcionDestino = scanner.nextInt();
            if (opcionDestino < 1 || opcionDestino > monedas.length) {
                System.out.println("Opción inválida");
                continue;
            }
            String destino = monedas[opcionDestino - 1];
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            try {
                double tasa = conversor.obtenerTasaConversion(origen, destino);
                double resultado = cantidad * tasa;
                System.out.printf("%.2f %s = %.2f %s\n", cantidad, origen, resultado, destino);
                historial.agregar(origen, destino, cantidad, resultado);
            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage());
            }
            System.out.println("¿Desea ver el historial de conversiones? (s/n)");
            String verHistorial = scanner.next();
            if (verHistorial.equalsIgnoreCase("s")) {
                for (HistorialConversion.Registro reg : historial.obtenerHistorial()) {
                    System.out.printf("%s: %.2f %s -> %.2f %s\n", reg.fecha, reg.cantidad, reg.origen, reg.resultado, reg.destino);
                }
            }
        }
        System.out.println("Gracias por usar el conversor de monedas.");
    }

}
