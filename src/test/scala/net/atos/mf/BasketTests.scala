package net.atos.mf

import org.scalatest.FreeSpec

/**
  * Created by mfearnley on 05/09/16.
  */
class BasketTests extends FreeSpec {

  /**
    * Test creation of Baskets with various items in
    */
  "Creating a basket with an empty item list should produce an empty basket" in {
    val basket = Basket.createFromItems(List())
    assert(basket.getItemNames.isEmpty)
  }

  "Creating a basket with a list containing 1 apple should produce a basket with just 1 apple in" in {
    val basket = Basket.createFromItems(List("apple"))
    assert(basket.getItemCount("apple") == 1)
    assert(basket.getItemNames.size == 1)
    assert(basket.getItemNames.contains("apple"))
  }

  "Creating a basket with a list containing 1 orange should produce a basket with just 1 orange in" in {
    val basket = Basket.createFromItems(List("orange"))
    assert(basket.getItemCount("orange") == 1)
    assert(basket.getItemNames.size == 1)
    assert(basket.getItemNames.contains("orange"))
  }

  "Creating a basket with a list containing 2048 Apples and 4097 Oranges " +
    "in should produce a basket with those Apples & Oranges" in {
    val basket = Basket.createFromItems(List.fill(2048)("apple") ++ List.fill(4097)("orange"))
    assert(basket.getItemCount("apple") == 2048)
    assert(basket.getItemCount("orange") == 4097)
    assert(basket.getItemNames.size == 2)
    assert(basket.getItemNames.contains("apple"))
    assert(basket.getItemNames.contains("orange"))
  }

  "The shopping basket treats fruit case-insensitively" in {
    val basket = Basket.createFromItems(List.fill(3)("Apple") ++ List.fill(3)("apple")
      ++ List.fill(4)("orange") ++ List.fill(4)("Orange"))
    assert(basket.getItemCount("apple") == 6)
    assert(basket.getItemCount("Orange") == 8)
  }

}
