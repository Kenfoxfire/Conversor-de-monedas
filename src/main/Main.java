package main;

import currencyExchange.ExchangeService;
import exception.ErrorDuringPairConversion;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String option = "-1";
        ExchangeService exchangeService;
        try {
        exchangeService = new ExchangeService();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Ha ocurrido un error al intentar instanciar a ExchangeService");
            return;
        }
        String baseCurrencyName = "";
        String targetCurrencyName = "";

        do {
            try {
                System.out.println("""
                        Ingresa una opcion para la conversion
                        1: Convertir Dolar USA a Colones CR
                        2: Convertir Colones CR a Dolar USA
                        3: Convertir Real brasileño a Colones CR
                        4: Convertir Colones CR a Real brasileño
                        5: Convertir Peso colombiano a Colones CR
                        6: Convertir Colones CR a Peso colombiano
                        7: Salir
                        """);

                option = sc.nextLine();
                switch ( option ) {
                    case "1":
                        exchangeService.setBaseCurrencyCode("USD");
                        baseCurrencyName = "Dolares";
                        exchangeService.setTargetCurrencyCode("CRC");
                        targetCurrencyName = "Colones";
                        break;
                    case "2":
                        exchangeService.setBaseCurrencyCode("CRC");
                        baseCurrencyName = "Colones";
                        exchangeService.setTargetCurrencyCode("USD");
                        targetCurrencyName = "Dolares";
                        break;
                    case "3":
                        exchangeService.setBaseCurrencyCode("BRL");
                        baseCurrencyName = "Reales";
                        exchangeService.setTargetCurrencyCode("CRC");
                        targetCurrencyName = "Colones";
                        break;
                    case "4":
                        exchangeService.setBaseCurrencyCode("CRC");
                        baseCurrencyName = "Colones";
                        exchangeService.setTargetCurrencyCode("BRL");
                        targetCurrencyName = "Reales";
                        break;
                    case "5":
                        exchangeService.setBaseCurrencyCode("COP");
                        baseCurrencyName = "Pesos";
                        exchangeService.setTargetCurrencyCode("CRC");
                        targetCurrencyName = "Colones";
                        break;
                    case "6":
                        exchangeService.setBaseCurrencyCode("CRC");
                        baseCurrencyName = "Colones";
                        exchangeService.setTargetCurrencyCode("COP");
                        targetCurrencyName = "Pesos";
                        break;
                    case "7":
                        System.out.println("Ten un buen dia");
                        return;

                    default:
                        System.out.println("Opcion incorrecta");
                        continue;
                }
                System.out.println("Ingresa el monto de " + baseCurrencyName + " a convertir");
                var baseCurrencyAmount = sc.nextLine();
                System.out.println(exchangeService.getCurrencyConversion(Double.parseDouble(baseCurrencyAmount), baseCurrencyName, targetCurrencyName));
            }catch (NumberFormatException e){
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            }catch (ErrorDuringPairConversion e){
                System.out.println("Ocurrió un error al convertir las monedas: ");
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: ");
                System.out.println(e.getMessage());
            }


        } while (!option.equals("7"));
        sc.close();

    }
}