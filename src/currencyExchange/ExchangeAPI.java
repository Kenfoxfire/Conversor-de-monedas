package currencyExchange;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ExchangeAPI {

    private final String apiKey;
    private final String apiURL;

    HttpClient client = HttpClient.newHttpClient();


    public ExchangeAPI() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/application.properties")) {
            props.load(fis);
            this.apiKey = props.getProperty("api.key");
            this.apiURL = props.getProperty("api.url");
        } catch (IOException e) {
            throw new RuntimeException("Error al establecer api url y api key, valida el archivo application.properties", e);
        }
    }

    private HttpRequest getRequest(String baseCurrency, String targetCurrency) {
        return HttpRequest.newBuilder()
                .uri(URI.create(apiURL + apiKey + String.format("/pair/%s/%s", baseCurrency, targetCurrency)))
                .build();
    }

    public String getPairConversionJson(String baseCurrencyCode, String targetCurrencyCode) {
        String jsonResponse = "";
        try {
            HttpResponse<String> response = client
                    .send(getRequest(baseCurrencyCode, targetCurrencyCode), HttpResponse.BodyHandlers.ofString());

            jsonResponse = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return jsonResponse;
    }
}
