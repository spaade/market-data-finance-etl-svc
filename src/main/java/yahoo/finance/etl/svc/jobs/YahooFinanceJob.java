package yahoo.finance.etl.svc.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import yahoo.finance.etl.svc.dtos.StockDTO;
import yahoo.finance.etl.svc.service.StocksService;
import yahoo.finance.etl.svc.yahoofinance.Stock;
import yahoo.finance.etl.svc.yahoofinance.YahooFinance;
import yahoo.finance.etl.svc.yahoofinance.histquotes2.CrumbManager;

import java.io.IOException;
import java.util.List;

@Component
public class YahooFinanceJob {

    private final static Logger log = LoggerFactory.getLogger(YahooFinanceJob.class);
    private final StocksService stocksService;
    private final WebClient webClient;

    @Autowired
    public YahooFinanceJob(StocksService stocksService, WebClient webClient) {
        this.stocksService = stocksService;
        this.webClient = webClient;
    }

    @Scheduled(initialDelay = 1L, fixedDelay = 1800000L)
    public void execute() throws IOException {
        List<StockDTO> stockDTOList = stocksService.findAllStocks().block();

        assert stockDTOList != null;
        for (StockDTO stockDTO : stockDTOList) {
            Stock stock = YahooFinance.get(stockDTO.symbol());
            stock.print();
        }

    }
}
