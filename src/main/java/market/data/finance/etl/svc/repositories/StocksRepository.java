package market.data.finance.etl.svc.repositories;

import market.data.finance.etl.svc.dtos.StockDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StocksRepository {

    Flux<StockDTO> findAllStocks();

    Mono<Void> postStock(StockDTO stockDTO);

}
