package data;

public class ProductData {

  private Integer productPrice;
  private String productName;

  private Integer limit;

  // Getter
  public Integer getProductPrice() { return productPrice; }

  public String getProductName() { return productName; }

  public Integer getLimit() { return limit; }

  // Setter
  public void setProductPrice(Integer price) { this.productPrice = price; }

  public void setProductName(String name) { this.productName = name; }

  public void setLimit(Integer limits) { this.limit = limits; }
}
