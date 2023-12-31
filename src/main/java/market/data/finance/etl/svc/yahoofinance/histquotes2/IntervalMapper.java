package market.data.finance.etl.svc.yahoofinance.histquotes2;


import market.data.finance.etl.svc.yahoofinance.histquotes.Interval;

/**
 * @author Stijn Strickx
 */
public class IntervalMapper {

    public static QueryInterval get(Interval interval) {
        switch (interval) {
            case DAILY:
                return QueryInterval.DAILY;
            case WEEKLY:
                return QueryInterval.WEEKLY;
            case MONTHLY:
                return QueryInterval.MONTHLY;
        }
        return QueryInterval.MONTHLY;
    }

}
