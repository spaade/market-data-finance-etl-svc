package yahoo.finance.etl.svc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import yahoo.finance.etl.svc.dtos.StockDTO;
import yahoo.finance.etl.svc.repositories.StocksRepository;
import yahoo.finance.etl.svc.service.StocksService;

import java.util.List;

@Service
public class StocksServiceImpl implements StocksService {

    private static final Logger log = LoggerFactory.getLogger(StocksServiceImpl.class);
    private final StocksRepository stocksRepository;

    @Autowired
    public StocksServiceImpl(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }

    @Override
    public Mono<List<StockDTO>> findAllStocks() {
        log.info("findAllStocks");
        return stocksRepository.findAllStocks()
                .collectList()
                .onErrorResume(error -> {
                    log.error("findAll error: {}", error.getMessage());
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<Void> postStock(StockDTO stockDTO) {
        log.info("postStock");
        return stocksRepository.postStock(stockDTO)
                .onErrorResume(error -> {
                    log.error("postStock error: {}", error.getMessage());
                    return Mono.error(error);
                });
    }
}
