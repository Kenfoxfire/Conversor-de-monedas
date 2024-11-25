# Currency Exchange Application

Aplicación de conversión de monedas que permite convertir entre diversas monedas, incluyendo Dólar estadounidense (USD), Colones costarricenses (CRC), Real brasileño (BRL) y Peso colombiano (COP). La aplicación permite al usuario seleccionar qué moneda desea convertir y luego ingresar la cantidad a convertir, mostrando el resultado de la conversión.

## Creador
- **Nombre**: Kenneth Sanabria Vargas
- **Programa de educación del proyecto**: Oracle Next Education - Alura Latam 2024

## Descripción del Proyecto

La aplicación permite al usuario convertir entre varias monedas, y utiliza un servicio de conversión de divisas para obtener las tasas de cambio actuales. Los usuarios pueden ingresar la cantidad a convertir y seleccionar la moneda base y la moneda destino de un menú de opciones.

## Características

- Soporta conversiones entre varias monedas:  
  1. Dólar USA (USD) a Colones CR (CRC)  
  2. Colones CR (CRC) a Dólar USA (USD)  
  3. Real brasileño (BRL) a Colones CR (CRC)  
  4. Colones CR (CRC) a Real brasileño (BRL)  
  5. Peso colombiano (COP) a Colones CR (CRC)  
  6. Colones CR (CRC) a Peso colombiano (COP)  
  7. Opción para salir del programa  

- El usuario puede ingresar la cantidad de la moneda base para obtener el monto convertido a la moneda destino.
- Manejo de errores.

## Requisitos

- **Java 11 o superior**: Asegúrate de tener una versión de Java instalada para ejecutar el proyecto.
- **Dependencias**: Este proyecto puede requerir dependencias adicionales, como una biblioteca para realizar peticiones HTTP, dependiendo de la implementación específica de `ExchangeService` recomendanda => google/gson.


## Configuracion

Deberás establecer tu API key y API url en el archivo `aplication.properties` en 'src\application.properties'.
Para este proyecto se utilizó https://app.exchangerate-api.com
