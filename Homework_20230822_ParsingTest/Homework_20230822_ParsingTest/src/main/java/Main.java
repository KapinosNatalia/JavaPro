public class Main {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser("report.json");
        StockBalance stockBalance = fileParser.parseFile();
        StockBalanceProcessor stockBalanceProcessor = new StockBalanceProcessor(stockBalance);
        System.out.println("List of ID:" + stockBalanceProcessor.getAllID());
        System.out.println("Most expensive SNACKS: " + stockBalanceProcessor.getMostExpensiveProductByCategory("SNACKS"));
        System.out.println("Most expensive product in money: " + stockBalanceProcessor.getMostMoneyProduct());
        System.out.println("Cheapest product in DRINKS: " + stockBalanceProcessor.getLessMoneyProductByCategory("DRINKS"));
        System.out.println("Quantity of actions products with category FOOD: " + stockBalanceProcessor.getQuantityOfActionsProductsByCategory("FOOD"));
        System.out.println("Grouping by ISPACKED: " + stockBalanceProcessor.groupingByPacking());
        System.out.println("Drinks with maximal margin: " + stockBalanceProcessor.getProductsWithMaxMargin("DRINKS"));
        System.out.println("Average margin by category FOOD: " + stockBalanceProcessor.getAverageMarginByCategory("FOOD"));
        System.out.println("3 products with minimal margin by category FOOD: " + stockBalanceProcessor.getProductsWithSmallestMargin("FOOD"));
        System.out.println("Treemap: " + stockBalanceProcessor.convertToTreeMap());
        System.out.println("Cheapest product in units and kg: " + stockBalanceProcessor.getCheapestProducts());
    }
}
