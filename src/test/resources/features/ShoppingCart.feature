@test.qa.engineer
Feature: Shopping Cart

  Scenario: Verify user able to make 1 transaction with price less than 10 million and other than the bag or watch category
    Given User logged into "voila.id"
    And User verify is already logged in
    And User go to sub-menu "SALE"
    And User find product on sale page by sort:
      | category | productType | filter       | maxPrice |
      | Clothing | Dress       | Availability | 9999999  |
    And User choose product number 1 product on sale page
    When User click + keranjang button on product page
    And User click "Lihat Keranjang" button on popup product added
    And User click checkout button on cart page
    And User verify is already landed on "Informasi" page
    And User input alamat field with "Irsyad - QA Engineer" on informasi page
    Then User verify data item price and product name is correct on informasi page