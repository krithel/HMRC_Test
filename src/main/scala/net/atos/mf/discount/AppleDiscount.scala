package net.atos.mf.discount

import net.atos.mf.{StockPrice, Basket}

/**
  * Created by mfearnley on 05/09/16.
  */
class AppleDiscount extends Discount {

  override def getDiscountAmount(basket: Basket, stockPrice: StockPrice): Int
    = (basket.getItemCount("apple") / 2) * stockPrice.getPriceForItem("apple")

}
