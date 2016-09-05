package net.atos.mf

import net.atos.mf.exception.InvalidItemException
import org.scalatest.FreeSpec

import scala.util.Random

/**
  * Tests for the Checkout class
  *
  * Created by mfearnley on 05/09/16.
  */
class CheckoutTests extends FreeSpec {

  val stockPrice = new StockPrice(Map("apple" -> 60, "orange" -> 25))

  "An empty basked should cost 0p" in {
    val basket = Basket.createFromItems(List())
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 0)
  }

  "A basket containing 1 Apple should cost 60p" in {
    val basket = Basket.createFromItems(List("apple"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 60)
  }

  "A basket containing 2 Apples should cost £1.20" in {
    val basket = Basket.createFromItems(List.fill(2)("apple"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 120)
  }

  "A basket containing 3 Apples should cost £1.80" in {
    val basket = Basket.createFromItems(List.fill(3)("apple"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 180)
  }

  "A basket containing 4 Apples should cost £2.40" in {
    val basket = Basket.createFromItems(List.fill(4)("apple"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 240)
  }

  "A basket containing 1 Orange should cost 25p" in {
    val basket = Basket.createFromItems(List("orange"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 25)
  }

  "A basket containing 2 Oranges should cost 50p" in {
    val basket = Basket.createFromItems(List.fill(2)("orange"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 50)
  }

  "A basket containing 3 Oranges should cost 75p" in {
    val basket = Basket.createFromItems(List.fill(3)("orange"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 75)
  }

  "A basket containing 4 Oranges should cost £1" in {
    val basket = Basket.createFromItems(List.fill(4)("orange"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 100)
  }

  "A basket containing a mix of 3 Apples and 5 Oranges should cost £3.05" in {
    val basket = Basket.createFromItems(Random.shuffle(List.fill(3)("apple") ++ List.fill(5)("orange")))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 305)
  }

  "A basket containing a mix of 2 Apples and 68 Oranges should cost £18.20" in {
    val basket = Basket.createFromItems(Random.shuffle(List.fill(2)("apple") ++ List.fill(68)("orange")))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 1820)
  }

  "A basket containing a mix of 74 Apples and 7 Oranges should cost £46.15" in {
    val basket = Basket.createFromItems(Random.shuffle(List.fill(74)("apple") ++ List.fill(7)("orange")))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 4615)
  }

  "A basket containing a mix of 5000 Apples and 1234 Oranges should cost £3308.50" in {
    val basket = Basket.createFromItems(Random.shuffle(List.fill(5000)("apple") ++ List.fill(1234)("orange")))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 330850)
  }

  "A list containing just an Apricot should cause an issue" in {
    val basket = Basket.createFromItems(List("pear"))
    val checkout = new Checkout(basket, stockPrice)

    assertThrows[InvalidItemException](checkout.getTotalCost)
  }

  "A list containing Apples, Oranges and an Apricot should cause an issue" in {
    val basket = Basket.createFromItems(Random.shuffle(List.fill(10)("apple") ++ List.fill(10)("orange") ++ List("apricot")))
    val checkout = new Checkout(basket, stockPrice)

    assertThrows[InvalidItemException](checkout.getTotalCost)
  }

  "A basket containing fruits should be treated case-insensitively" in {
    val basket = Basket.createFromItems(List("apple", "Apple", "APplE", "ORANGE", "orange", "ORAnge", "Orange"))
    val checkout = new Checkout(basket, stockPrice)

    assert(checkout.getTotalCost == 280)
  }

}
