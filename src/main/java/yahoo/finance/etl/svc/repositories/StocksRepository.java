package yahoo.finance.etl.svc.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yahoo.finance.etl.svc.dtos.StockDTO;

public interface StocksRepository {

    Flux<StockDTO> findAllStocks();

    Mono<Void> postStock(StockDTO stockDTO);

}
