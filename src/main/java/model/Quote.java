package model;


import lombok.NoArgsConstructor;
import my_spring.InjectId;
import my_spring.InjectRandomQuote;
import my_spring.RunThisMethode;

import java.io.Serializable;

@NoArgsConstructor
public class Quote implements Serializable {
    @InjectId
    private int id;
    @InjectRandomQuote
    private String quote;
    private QuoteLength length;

    @RunThisMethode
    public void setLength() {
        this.length = QuoteLength.findQuoteLength(quote);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", length=" + length +
                '}';
    }

}
