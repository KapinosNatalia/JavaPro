import java.util.ArrayList;
import java.util.List;

public class StockBalance {
    private List<ProductInfo> productsList = new ArrayList<>();

    public List<ProductInfo> getProductsList() {
        return productsList;
    }

    public void addProductInfo(ProductInfo productInfo) {
        if (productInfo == null) {
            throw new NullPointerException("ProductInfo couldn't be NULL");
        }
        if (productsList.stream().anyMatch(product -> product.getId() == productInfo.getId())) {
            throw new ProductInfoAlreadyExistException("ProductInfo with ID " + productInfo.getId() + " already exist");
        }
        productsList.add(productInfo);
    }

    @Override
    public String toString() {
        return "StockBalance{" +
                "productsList=" + productsList +
                '}' + "\n";
    }
}
