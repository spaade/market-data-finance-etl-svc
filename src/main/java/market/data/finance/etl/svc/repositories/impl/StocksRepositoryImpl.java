package market.data.finance.etl.svc.repositories.impl;

import market.data.finance.etl.svc.dtos.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import market.data.finance.etl.svc.repositories.StocksRepository;

@Component
public class StocksRepositoryImpl implements StocksRepository {

    private static final Logger log = LoggerFactory.getLogger(StocksRepositoryImpl.class);
    private final DatabaseClient databaseClient;

    @Autowired
    public StocksRepositoryImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Flux<StockDTO> findAllStocks() {
        var query = """
                SELECT
                    id,
                    symbol,
                    name,
                    currency,
                    stockExchange,
                    quote,
                    stats,
                    dividend FROM stocks;
                """;
        return databaseClient.sql(query).map(((row, rowMetadata) -> new StockDTO(
                        row.get("id", Long.class),
                        row.get("symbol", String.class),
                        row.get("name", String.class),
                        row.get("currency", String.class),
                        row.get("stockExchange", String.class),
                        row.get("quote", String.class),
                        row.get("stats", String.class),
                        row.get("dividend", String.class)
                ))).all()
                .collectList()
                .flatMapMany(Flux::fromIterable)
                .onErrorResume(throwable -> {
                    log.error("findAllStocks error: {}", throwable.getMessage());
                    return Flux.error(throwable);
                });
    }

    @Override
    public Mono<Void> postStock(StockDTO stockDTO) {
        var query = """
                INSERT INTO stocks (symbol, name, currency, stockExchange, quote, stats, dividend)
                VALUES (:symbol, :name, :currency, :stockExchange, :quote, :stats, :dividend);
                """;

        return databaseClient.sql(query)
                .bind("symbol", stockDTO.symbol())
                .bind("name", stockDTO.name())
                .bind("currency", stockDTO.currency())
                .bind("stockExchange", stockDTO.stockExchange())
                .bind("quote", stockDTO.quote())
                .bind("stats", stockDTO.stats())
                .bind("dividend", stockDTO.dividend())
                .fetch()
                .rowsUpdated()
                .then()
                .onErrorResume(throwable -> {
                    log.error("insertStock error: {}", throwable.getMessage());
                    return Mono.error(throwable);
                });
    }
}
