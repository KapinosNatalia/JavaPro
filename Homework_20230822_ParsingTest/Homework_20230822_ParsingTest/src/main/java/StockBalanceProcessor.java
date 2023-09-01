import java.util.*;
import java.util.stream.Collectors;

public class StockBalanceProcessor {
    private final StockBalance stockBalance;

    public StockBalanceProcessor(StockBalance stockBalance) {
        this.stockBalance = stockBalance;
    }

    //     Методы, которые находят:
    //    *  ай ди всех товаров
    public List<Integer> getAllID() {
        return stockBalance.getProductsList().stream()
                .map(ProductInfo::getId)
                .toList();
    }

    //    *  самый дорогой СНЭК
    public ProductInfo getMostExpensiveProductByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        return stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .sorted(Comparator.comparing(ProductInfo::getPrice, Comparator.reverseOrder()))
                .limit(1)
                .toList().get(0);
    }

    //    *  какого товара больше всего на складе в деньгах
    public List<ProductInfo> getMostMoneyProduct() {
        double maxSum = stockBalance.getProductsList().stream()
                .map(productInfo -> productInfo.getPrice() * productInfo.getQuantity())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .toList().get(0);
        return stockBalance.getProductsList().stream()
                .collect(Collectors.toMap(productInfo -> productInfo, productInfo -> productInfo.getPrice() * productInfo.getQuantity()))
                .entrySet().stream()
                .filter(productInfoDoubleEntry -> productInfoDoubleEntry.getValue() == maxSum)
                .map(Map.Entry::getKey)
                .toList();
    }

    //    *  какого ДРИНКС товара меньше всего на складе в деньгах
    public List<ProductInfo> getLessMoneyProductByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        double minSum = stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .map(productInfo -> productInfo.getPrice() * productInfo.getQuantity())
                .sorted()
                .limit(1)
                .toList().get(0);
        return stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .collect(Collectors.toMap(productInfo -> productInfo, productInfo -> productInfo.getPrice() * productInfo.getQuantity()))
                .entrySet().stream()
                .filter(productInfoDoubleEntry -> productInfoDoubleEntry.getValue() == minSum)
                .map(Map.Entry::getKey)
                .toList();
    }

    //    *  количество видов акционного товара у ФУД
    public int getQuantityOfActionsProductsByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        return (int) stockBalance.getProductsList().stream()
                .filter(productInfo -> (category.equals(productInfo.getCategory()) && productInfo.isAdv()))
                .count();
    }

    //    *  сгруппировать по упакованным и нет
    public Map<Boolean, List<ProductInfo>> groupingByPacking() {
        return stockBalance.getProductsList().stream()
                .collect(Collectors.groupingBy(ProductInfo::isPacked));
    }

    //    *  у какого ДРИНКС самая высокая маржа
    public List<ProductInfo> getProductsWithMaxMargin(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        double maxMargin = stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .map(ProductInfo::getMargin)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .toList().get(0);

        return stockBalance.getProductsList().stream()
                .filter(productInfo -> (category.equals(productInfo.getCategory()) && productInfo.getMargin() == maxMargin))
                .toList();
    }

    //    *  средняя маржа по категории
    public double getAverageMarginByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        return stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .mapToDouble(ProductInfo::getMargin)
                .average().getAsDouble();
    }

    //    *  первые три товара ФУД, которые участвуют в акции, и у которых самая низкая маржа
    public List<ProductInfo> getProductsWithSmallestMargin(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category couldn't be empty");
        }
        return stockBalance.getProductsList().stream()
                .filter(productInfo -> category.equals(productInfo.getCategory()))
                .sorted(Comparator.comparing(ProductInfo::getMargin, Comparator.naturalOrder()))
                .limit(3)
                .toList();
    }

    //    *  поместить в три мапу отсортировав в ай ди. #37 - это ай ди
    public Map<Integer, ProductInfo> convertToTreeMap() {
        Map<Integer, ProductInfo> treeMap = new TreeMap<>();
        stockBalance.getProductsList().stream()
                .forEach(productInfo -> treeMap.put(productInfo.getId(), productInfo));
        return treeMap;
    }

    //    *  самый дешевый товар которого меньше всего на складе осталось в кг или штуках в зависимости от ISPACKED
    public Map<String, ProductInfo> getCheapestProducts() {
        Map<String, ProductInfo> map = new HashMap<>();
        map.put("is packed (unit)", stockBalance.getProductsList().stream()
                .filter(ProductInfo::isPacked)
                .sorted(Comparator.comparing(ProductInfo::getQuantity).thenComparing(ProductInfo::getPrice))
                .limit(1)
                .findFirst().get());
        map.put("is not packed (kg)", stockBalance.getProductsList().stream()
                .filter(productInfo -> !productInfo.isPacked())
                .sorted(Comparator.comparing(ProductInfo::getQuantity).thenComparing(ProductInfo::getPrice))
                .limit(1)
                .findFirst().get());
        return map;
    }
}
