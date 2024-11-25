package model;

import com.google.gson.annotations.SerializedName;

public record ExchangeRecordRes(
        @SerializedName("result") String result,
        @SerializedName("conversion_rate") double conversionRate
) {}
