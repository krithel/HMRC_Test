package net.atos.mf

import net.atos.mf.exception.InvalidItemException

/**
  * The prices of all stock items in the store.
  *
  * Created by mfearnley on 05/09/16.
  */
class StockPrice (val itemPrices: Map[String, Int]) {

  /**
    * Get the price of a specific item.
    *
    * @param item Name of the item to price
    * @return Price of the item
    * @throws InvalidItemException Thrown if the item doesn't exist
    */
  def getPriceForItem(item: String): Int = throw new NotImplementedError
}
