import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void updatePrice() {
        this.price += (Math.random() - 0.5) * 10;
        if (price < 1) price = 1;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Stock> stocks = new HashMap<>();
        Map<String, Integer> portfolio = new HashMap<>();

        stocks.put("AAPL", new Stock("AAPL", 150));
        stocks.put("GOOG", new Stock("GOOG", 2800));
        stocks.put("TSLA", new Stock("TSLA", 700));

        while (true) {
            System.out.println("\n1. View Stocks\n2. Buy Stock\n3. Sell Stock\n4. View Portfolio\n5. Exit");
            int choice = scanner.nextInt();

            for (Stock stock : stocks.values()) stock.updatePrice();

            switch (choice) {
                case 1:
                    System.out.println("Stock Prices:");
                    for (Stock stock : stocks.values()) {
                        System.out.printf("%s: $%.2f\n", stock.name, stock.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.next().toUpperCase();
                    if (stocks.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        portfolio.put(buySymbol, portfolio.getOrDefault(buySymbol, 0) + qty);
                        System.out.println("Bought " + qty + " shares of " + buySymbol);
                    } else {
                        System.out.println("Invalid stock.");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.next().toUpperCase();
                    if (portfolio.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int sellQty = scanner.nextInt();
                        int ownedQty = portfolio.get(sellSymbol);
                        if (sellQty <= ownedQty) {
                            portfolio.put(sellSymbol, ownedQty - sellQty);
                            System.out.println("Sold " + sellQty + " shares of " + sellSymbol);
                        } else {
                            System.out.println("Not enough shares.");
                        }
                    } else {
                        System.out.println("You don’t own that stock.");
                    }
                    break;

                case 4:
                    System.out.println("Portfolio:");
                    double totalValue = 0;
                    for (String symbol : portfolio.keySet()) {
                        int qty = portfolio.get(symbol);
                        double value = stocks.get(symbol).price * qty;
                        totalValue += value;
                        System.out.printf("%s: %d shares, Value: $%.2f\n", symbol, qty, value);
                    }
                    System.out.printf("Total Portfolio Value: $%.2f\n", totalValue);
                    break;

                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
            }
        }
    }
}
