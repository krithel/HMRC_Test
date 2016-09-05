package net.atos.mf

import net.atos.mf.discount.{OrangeDiscount, AppleDiscount}
import org.scalatest.FreeSpec

/**
  * Tests for all possible discounts
  *
  * Created by mfearnley on 05/09/16.
  */
class DiscountTests extends FreeSpec {

  val stockPrice = new StockPrice(Map("apple" -> 60, "orange" -> 25))

  "0 Apples should give a discount of 0p" in {
    val basket = Basket.createFromItems(List())
    assert((new AppleDiscount).getDiscountAmount(basket, stockPrice) == 0)
  }

  "1 Apple should give a discount of 0p" in {
    val basket = Basket.createFromItems(List("apple"))
    assert((new AppleDiscount).getDiscountAmount(basket, stockPrice) == 0)
  }

  "2 Apples should give a discount of 60p" in {
    val basket = Basket.createFromItems(List.fill(2)("apple"))
    assert((new AppleDiscount).getDiscountAmount(basket, stockPrice) == 60)
  }

  "3 Apples should give a discount of 60p" in {
    val basket = Basket.createFromItems(List.fill(3)("apple"))
    assert((new AppleDiscount).getDiscountAmount(basket, stockPrice) == 60)
  }

  "4 Apples should give a discount of £1.20" in {
    val basket = Basket.createFromItems(List.fill(4)("apple"))
    assert((new AppleDiscount).getDiscountAmount(basket, stockPrice) == 120)
  }

  "0 Oranges should give a discount of 0p" in {
    val basket = Basket.createFromItems(List())
    assert((new OrangeDiscount).getDiscountAmount(basket, stockPrice) == 0)
  }

  "1 Orange should give a discount of 0p" in {
    val basket = Basket.createFromItems(List("orange"))
    assert((new OrangeDiscount).getDiscountAmount(basket, stockPrice) == 0)
  }

  "3 Oranges should give a discount of 25p" in {
    val basket = Basket.createFromItems(List.fill(3)("orange"))
    assert((new OrangeDiscount).getDiscountAmount(basket, stockPrice) == 25)
  }

  "5 Oranges should give a discount of 25p" in {
    val basket = Basket.createFromItems(List.fill(5)("orange"))
    assert((new OrangeDiscount).getDiscountAmount(basket, stockPrice) == 25)
  }

  "6 Oranges should give a discount of 50p" in {
    val basket = Basket.createFromItems(List.fill(6)("orange"))
    assert((new OrangeDiscount).getDiscountAmount(basket, stockPrice) == 50)
  }
}
