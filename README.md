# Convertidor de Moneda

## Descripción
Aplicación de consola en Java que permite convertir entre diferentes monedas utilizando la API ExchangeRate-API. El usuario puede seleccionar monedas, ingresar montos, ver el resultado de la conversión y consultar el historial de conversiones.

## Características
- Consulta de tasas de cambio en tiempo real usando ExchangeRate-API.
- Conversión entre las siguientes monedas: ARS, BOB, BRL, CLP, COP, USD.
- Interfaz de usuario por consola con menú interactivo.
- Registro de historial de conversiones con marca de tiempo.
- Pruebas unitarias para la lógica principal.

## Tecnologías utilizadas
- Java 17
- Spring Boot 4
- Gson 2.13.2
- HttpClient (Java estándar)
- JUnit 5

## Instalación y ejecución
1. Clona el repositorio o descarga el código fuente.
2. Asegúrate de tener Java 17 y Maven instalados.
3. Ejecuta `mvn clean install` para compilar el proyecto y descargar dependencias.
4. Ejecuta la aplicación con:
   ```
   mvn spring-boot:run
   ```

## Uso
- Sigue las instrucciones en consola para seleccionar monedas y realizar conversiones.
- Puedes ver el historial de conversiones al finalizar cada operación.

## Configuración de la API
- La clave de API de ExchangeRate-API está incluida en el código para fines educativos. Para producción, obtén tu propia clave en [ExchangeRate-API](https://www.exchangerate-api.com/).

## Estructura del proyecto
- `ConvertidorMonedaApplication.java`: Clase principal y menú interactivo.
- `ConversorService.java`: Lógica de consumo de API y conversión.
- `HistorialConversion.java`: Registro de historial de conversiones.
- Pruebas en `src/test/java/oracle/alura/convertidormoneda/`.

## Funcionalidades extra
- Historial de conversiones con fecha y hora.
- Fácil extensión para agregar más monedas.

## Créditos
Desarrollado como parte del Challenge Oracle-Alura LATAM.

---

> **Nota:** Este proyecto es educativo y la clave de API puede estar sujeta a límites de uso.
