package yahoo.finance.etl.svc.dtos;

public record StockDTO(
        Long id,
        String symbol,
        String name,
        String currency,
        String stockExchange,
        String quote,
        String stats,
        String dividend) {
}
