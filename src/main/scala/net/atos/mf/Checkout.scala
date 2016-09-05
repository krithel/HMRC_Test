package net.atos.mf

/**
  * The Checkout handles getting prices for Baskets of items
  *
  * Created by mfearnley on 05/09/16.
  */
class Checkout (val basket: Basket, val stockPrice: StockPrice) {

  /**
    * Get the total cost of all items passed into the checkout, based on the given Stock Price
    *
    * @return Price (in pence) of the basket
    */
  def getTotalCost: Int = basket.getItemNames.foldLeft(0)((totalPrice, item) =>
    totalPrice + getCostOfItem(item))

  /**
    * Get the total cost of a single type of item
    *
    * @param item Item type to price
    * @return Total cost of all instances of a single type of item
    */
  private def getCostOfItem(item: String) = basket.getItemCount(item) * stockPrice.getPriceForItem(item)
}
