package net.atos.mf.discount

import net.atos.mf.{StockPrice, Basket}

/**
  * Trait to create an Discount class which applies a specific discount to a basket
  *
  * Created by mfearnley on 05/09/16.
  */
trait Discount {

  /**
    * Get the total discount value for a basket
    *
    * @param basket Basket containing items to discount
    * @param stockPrice Current Stock Price of the store
    * @return Total amount to reduce the total price by
    */
  def getDiscountAmount(basket: Basket, stockPrice: StockPrice): Int

}
