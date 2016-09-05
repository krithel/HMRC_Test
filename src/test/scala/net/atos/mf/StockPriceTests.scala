package net.atos.mf

import net.atos.mf.exception.InvalidItemException
import org.scalatest.{BeforeAndAfter, FreeSpec}

/**
  * Tests for the StockPrice class
  *
  * Created by mfearnley on 05/09/16.
  */
class StockPriceTests extends FreeSpec with BeforeAndAfter {

  var stockPrice: StockPrice = _

  before {
    stockPrice = new StockPrice(Map("apple" -> 60, "orange" -> 25))
  }

  "Apples should cost 60p" in {
    assert(stockPrice.getPriceForItem("apple") == 60)
  }

  "Oranges should cost 25p" in {
    assert(stockPrice.getPriceForItem("orange") == 25)
  }

  "Apricots should cause an issue" in {
    assertThrows[InvalidItemException](stockPrice.getPriceForItem("apricot"))
  }
}
