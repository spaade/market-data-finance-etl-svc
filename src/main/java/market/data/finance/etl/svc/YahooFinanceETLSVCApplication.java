package market.data.finance.etl.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YahooFinanceETLSVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(YahooFinanceETLSVCApplication.class);
    }

}