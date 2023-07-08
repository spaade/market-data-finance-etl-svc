package yahoo.finance.etl.svc.service;

import reactor.core.publisher.Mono;
import yahoo.finance.etl.svc.dtos.StockDTO;

import java.util.List;

public interface StocksService {

    Mono<List<StockDTO>> findAllStocks();

    Mono<Void> postStock(StockDTO stockDTO);
}
