package market.data.finance.etl.svc.service;

import market.data.finance.etl.svc.dtos.StockDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StocksService {

    Mono<List<StockDTO>> findAllStocks();

    Mono<Void> postStock(StockDTO stockDTO);
}
