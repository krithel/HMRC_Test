package net.atos.mf

/**
  * The Checkout handles getting prices for Baskets of items
  *
  * Created by mfearnley on 05/09/16.
  */
class Checkout (val basket: Basket, val stockPrice: StockPrice) {

  def getTotalCost: Int = throw new NotImplementedError
}
