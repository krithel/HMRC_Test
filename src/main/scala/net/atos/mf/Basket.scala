package net.atos.mf

/**
  * Basket which stores items for shoppers
  *
  * Created by mfearnley on 05/09/16.
  */
class Basket (private val items: Map[String, Int]) {

  /**
    * Get a count of how many of a particular item is in a basket
    *
    * @param item Item to get the count of
    * @return Number of instances of the item in basket
    */
  def getItemCount(item: String): Int = throw new NotImplementedError

  /**
    * Get the names of all items in the basket
    *
    * @return List of names of all items in the basket
    */
  def getItemNames: List[String] = throw new NotImplementedError
}

/**
  * Helper methods for creating a Basket
  */
object Basket {

  /**
    * Create a basket from a list of shopping items
    *
    * @param items List of shopping item products
    * @return New populated basket
    */
  def createFromItems(items: List[String]): Basket = throw new NotImplementedError
}
