package yahoo.finance.etl.svc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("stocks")
public class StockEntity {

    @Id
    private Long id;
    private String symbol;
    private String name;
    private String currency;
    private String stockExchange;
    private String quote;
    private String stats;
    private String dividend;

    public StockEntity(Long id, String symbol, String name, String currency, String stockExchange, String quote, String stats, String dividend) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
        this.stockExchange = stockExchange;
        this.quote = quote;
        this.stats = stats;
        this.dividend = dividend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getDividend() {
        return dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }
}
