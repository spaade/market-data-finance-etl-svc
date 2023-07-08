package yahoo.finance.etl.svc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import yahoo.finance.etl.svc.dtos.StockDTO;
import yahoo.finance.etl.svc.service.StocksService;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StocksController {

    private final StocksService stocksService;

    @Autowired
    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping
    public Mono<List<StockDTO>> findAllStocks() {
        return stocksService.findAllStocks();
    }

    @PostMapping
    public Mono<Void> postStock(@RequestBody StockDTO stockDTO) {
        return stocksService.postStock(stockDTO);
    }
}
