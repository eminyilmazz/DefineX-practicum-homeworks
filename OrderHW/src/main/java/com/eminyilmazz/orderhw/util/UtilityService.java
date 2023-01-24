package com.eminyilmazz.orderhw.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class UtilityService {
    public static String formatCurrency(Long l) {
        String amount = String.valueOf(Double.valueOf(l) / 100);
        Locale locale = new Locale("en", "US");
        Currency currency = Currency.getInstance(locale);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        BigDecimal bigDecimal = new BigDecimal(amount);
        return numberFormat.format(bigDecimal);
    }
}
