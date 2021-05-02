package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum QuoteLength implements Serializable {
    SHORT(),
    MEDIUM(),
    LONG();

    private static final List<QuoteLength> lengthList = Arrays.asList(QuoteLength.values());

    public static QuoteLength findQuoteLength(String quote) {
        int index = quote.length() / 10;

        if (index > 2)
            index = 2;

        return lengthList.get(index);
    }
}
