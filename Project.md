Descripción
En este paso crucial, es fundamental comprender mejor la API de tasas de cambio, revisar su documentación y aprender cómo obtener la clave de API.

Esta clave es esencial para realizar solicitudes y obtener datos actualizados.

Asegúrate de seguir cuidadosamente las instrucciones proporcionadas por la API Exchange Rate API u otra similar que hayas elegido.

→ Recuerde que para generar su clave de API es necesario crear una cuenta en el sitio.

Enlace: ExchangeRate-API - Free & Pro Currency Converter API

Consulta por pares
Encontramos el tipo de consulta en pares óptima para realizar el proyecto, basta con insertar 2 códigos referentes a las monedas que desea consultar la tasa de conversión:

"https://v6.exchangerate-api.com/v6/<su-clave-aquí>/pair/";
AQUI MI KEY
Your API Key: 156926c095b0fdabbdc56be3
Example Request: https://v6.exchangerate-api.com/v6/156926c095b0fdabbdc56be3/latest/USD

PASO 2
Descripción
Para importar la biblioteca Gson en IntelliJ, sigue estos pasos:
<!-- Source: https://mvnrepository.com/artifact/com.google.code.gson/gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.13.2</version>
    <scope>compile</scope>
</dependency>
Abre tu proyecto en IntelliJ.

Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.

Selecciona "Open Module Settings" en el menú contextual.

En la ventana que se abre, ve a la pestaña "Dependencies".

Haz clic en el signo "+" en la esquina inferior izquierda y elige "Library".

Busca "gson" en el cuadro de búsqueda.

Selecciona la versión de Gson que desees utilizar.

Haz clic en "OK" para cerrar la ventana.

Ahora, la biblioteca Gson está agregada a tu proyecto y puedes comenzar a utilizarla importando sus clases en tus archivos Java. Por ejemplo:

Descripción Imagen 1 - La imagen muestra la ventana Project Structure de IntelliJ IDEA, donde el usuario está en la sección de configuración de módulos. La pestaña Dependencies está seleccionada, indicando que el usuario está gestionando las dependencias del proyecto.

Preview unavailable
Descripción Imagen 2 - La imagen muestra el código fuente de un archivo Java llamado ConversorApp.java abierto en IntelliJ IDEA. El código pertenece al paquete lad.com.alura.conversormoneda y utiliza la biblioteca Gson para manipular JSON.

https://trello.com/1/cards/65d8aafe04979a69e848b0a0/attachments/67d44aee09d4b2e323656254/download/ejemplo-uso-del-gson-en-codigo-java.png
Código de la imagen 2:



package lad.com.alura.conversormoneda;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
public class ConversorApp {
public static void main(String[] args) throws IOException, InterruptedException  {
Conversor.eleccionUserMenu();
}
public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
//Código omitido
//Conversión a JSON
JsonElement elemento = JsonParser.parseString(respuesta.body());
JsonObject objectRoot = elemento.getAsJsonObject();
//Accediendo a JsonObject
double tasa = objectRoot.get("conversion_rate").getAsDouble();
return tasa;
}
}

paso 3

Descripción
En la cuarta fase de nuestro desafío, empleamos la clase HttpClient para realizar solicitudes a la API de tasas de cambio y obtener datos esenciales.

El uso de HttpClient en Java facilita la conexión y la obtención de respuestas de manera eficiente.

Además, proporciona una base sólida para realizar operaciones HTTP de manera más estructurada y versátil. Explorar y entender el manejo de esta clase en Java no solo optimiza el proceso de solicitud.

Dejamos un ejemplo práctico:



// Creando cliente HTTP
HttpClient cliente = HttpClient.newHttpClient();
// Código omitido

paso 4
Descripción
En la sexta fase de nuestro desafío, nos enfocamos en el uso de la interfaz HttpResponse para gestionar las respuestas recibidas de la API.

La interfaz HttpResponse en Java ofrece una estructura que permite acceder y analizar los diferentes elementos de una respuesta HTTP.

Al entender cómo trabajar con esta interfaz, podrás extraer información significativa de las respuestas, como códigos de estado, encabezados y el cuerpo de la respuesta, que normalmente se presenta en formato JSON.

Dejamos un ejemplo práctico:



HttpClient cliente = HttpClient.newHttpClient();
//Código omitido
HttpRequest solicitud = HttpRequest.newBuilder()
.uri(URI.create(url))
.GET()
.build();
try {
// Enviando solicitud y recibiendo respuesta
HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
catch (Exception e){
//Código omitido

PASO 5
Descripción
En la séptima fase de nuestro desafío, nos sumergimos en el análisis de la respuesta JSON utilizando la biblioteca Gson en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.

--> Para facilitar el análisis de los datos que se obtendrán de la API, recomendamos el uso de herramientas como Postman.

Con la biblioteca Gson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

Recuerda utilizar las clases proporcionadas por Gson, como JsonParser y JsonObject, para acceder a las distintas propiedades de la respuesta JSON.

paso 6

Descripción
En la octava fase de nuestro desafío, nos enfocamos en el proceso de filtrar las monedas utilizando la biblioteca Gson en Java.

Para acceder a datos específicos, como los valores de las diferentes monedas, es esencial comprender cómo navegar por la estructura JSON de la respuesta de la API.

Estructura JSON:

Descripción Imagen 1 - La imagen muestra un JSON de respuesta de una API de tipos de cambio (ExchangeRate-API). El JSON contiene información sobre la última actualización de las tasas de conversión de divisas, basadas en el dólar estadounidense (USD).

Preview unavailable
Enlace: Java Exchange Rate API | Java Currency Converter

Para el filtrado de monedas, será necesario utilizar el atributo "Currency Code" del JSON. Para el desafío, podrás elegir al menos tres "Currency Code" para incluir en tu aplicación. Estos códigos son:

ARS - Peso argentino

BOB - Boliviano boliviano

BRL - Real brasileño

CLP - Peso chileno

COP - Peso colombiano

USD - Dólar estadounidense

Descripción Imagen 2 - Página de la ExchangeRate-API que muestra todas las opciones disponibles para realizar el cambio. Destacan las siguientes monedas: Peso argentino (ARS), Boliviano (BOB), Real brasileño (BRL), Peso chileno (CLP) y Peso colombiano (COP).

Preview unavailable
Enlace: ExchangeRate-API - Supported Currency Codes and Countries


PASO 7

Descripción
En esta novena fase, finalmente realizaremos las conversiones entre las monedas, ahora que ya tenemos los valores de las tasas de cambio en nuestras manos raised_hands

De este modo, el próximo paso es implementar la lógica de conversión utilizando las tasas obtenidas para calcular los valores convertidos entre las monedas deseadas.

TIP: Una sugerencia es crear métodos o funciones específicas para llevar a cabo estos cálculos, lo que hará que el código sea más modular y fácil de comprender.

Experimenta utilizando variables para almacenar los valores ingresados por el usuario, aplicar las tasas de conversión y mostrar los resultados finales.

Esta fase representa la culminación del desafío, donde todas las piezas encajan para ofrecer una experiencia completa de conversión de monedas.

PASO 8

escripción
En esta etapa del desafío, nos adentraremos en la interacción con el usuario, implementando una interfaz textual a través de la consola que presenta opciones de conversión de monedas. La estructura incluirá un menú dentro de un bucle de repetición, permitiendo al usuario seleccionar opciones numéricas y proporcionar datos para la conversión, utilizando la clase Scanner para capturar la entrada do usuário.

Al final, el programa mostrará el valor convertido según la elección del usuario. Además, es fundamental realizar pruebas exhaustivas para garantizar el correcto funcionamiento del programa, simulando diversas situaciones y recorridos para identificar y corregir posibles errores.

A continuación, un ejemplo de cómo podrías estructurar tu menú para interactuar con el usuario en tu conversor de monedas. Úsalo como inspiración rocket

Descripción Imagen 1 - La imagen muestra un fragmento de código en Java, específicamente la declaración de una clase llamada "Conversor" y un método dentro de esa clase llamado "exibirMenu".

Esta clase tiene el texto en System.out.println como: “Sea bienvenido/a al Conversor de Moneda”, y luego las 6 opciones de monedas para establecer el cambio, y por fin tiene “Elija una opción válida”.

https://trello.com/1/cards/65d8aafe04979a69e848b09c/attachments/67d4707655e87e43b464f202/download/menu-conversor-de-moneda.jpg


PASO 9
Descripción
Excelente!blue_heart
En caso de que quieras desafiarte aún más y proporcionar a los usuarios una experiencia más rica y personalizada, hay diversas funcionalidades interesantes que puedes explorar:

Historial de Conversiones: Agrega la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.

Soporte para Más Monedas: Amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.

Registros con Marca de Tiempo: Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.

¡Desafíate a implementar estas características y convierte tu proyecto en una herramienta aún más poderosa y versátil!
PASO 10
haz el README.md