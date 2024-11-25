package currencyExchange;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ErrorDuringPairConversion;
import model.ExchangeRecordRes;

public class ExchangeService {

    String baseCurrencyCode;
    String targetCurrencyCode;

    ExchangeAPI api = new ExchangeAPI();

    public ExchangeService(String baseCurrencyCode, String targetCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public ExchangeService() {
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        if (baseCurrencyCode.isBlank()) return;
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        if (targetCurrencyCode.isBlank()) return;
        this.targetCurrencyCode = targetCurrencyCode;
    }

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();


    private double getConversionRate() {
        var json = api.getPairConversionJson(baseCurrencyCode, targetCurrencyCode);
        if (json.isEmpty()) {
            throw new ErrorDuringPairConversion("Ha ocurrido un error cuando se intentó consultar a exchangerate-api con baseCurrencyCode "+ baseCurrencyCode +" y targetCurrencyCode "+ targetCurrencyCode);
        }
        ExchangeRecordRes exchangeRecordRes = gson.fromJson(json, ExchangeRecordRes.class);

        if (exchangeRecordRes.result().equals("success")) {
            return exchangeRecordRes.conversionRate();
        }else {
            throw new ErrorDuringPairConversion("Ha ocurrido un error cuando se intentó consultar a exchangerate-api con baseCurrencyCode "+ baseCurrencyCode +" y targetCurrencyCode "+ targetCurrencyCode);
        }
    }

    public String getCurrencyConversion(double baseCurrencyAmount, String baseCurrencyName, String targetCurrencyName) {
        var conversionRate = getConversionRate();
        var currencyConversion = conversionRate * baseCurrencyAmount;
        return """
                La conversion de %s %s es de %s %s
                """.formatted(baseCurrencyAmount, baseCurrencyName, currencyConversion, targetCurrencyName);
    }
}
