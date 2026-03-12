package oracle.alura.convertidormoneda;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

public class ConversorService {
    private static final String API_KEY = "156926c095b0fdabbdc56be3";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private static final Set<String> SUPPORTED_CURRENCIES = Set.of("ARS", "BOB", "BRL", "CLP", "COP", "USD");

    public JsonObject obtenerTasas(String baseCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + baseCurrency;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        JsonElement elemento = JsonParser.parseString(respuesta.body());
        return elemento.getAsJsonObject();
    }

    public double obtenerTasaConversion(String base, String destino) throws IOException, InterruptedException {
        if (!SUPPORTED_CURRENCIES.contains(base) || !SUPPORTED_CURRENCIES.contains(destino)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }
        JsonObject tasas = obtenerTasas(base);
        JsonObject conversionRates = tasas.getAsJsonObject("conversion_rates");
        return conversionRates.get(destino).getAsDouble();
    }

    public Set<String> getSupportedCurrencies() {
        return SUPPORTED_CURRENCIES;
    }
}

