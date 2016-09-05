package net.atos.mf.discount

import net.atos.mf.{StockPrice, Basket}

/**
  * Created by mfearnley on 05/09/16.
  */
class OrangeDiscount extends Discount {

  override def getDiscountAmount(basket: Basket, stockPrice: StockPrice): Int = throw new NotImplementedError

}
