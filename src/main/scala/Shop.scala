import net.atos.mf.{StockPrice, Basket, Checkout}

/**
  * Created by mfearnley on 05/09/16.
  */
object Shop {

  def main(args: Array[String]): Unit = {

    val stockPrice = new StockPrice(Map("apple" -> 60, "orange" -> 25))
    val basket = Basket.createFromItems(args.toList)
    val checkout = new Checkout(basket, stockPrice)

    println(s"Total price of your basket is ${getDisplayablePrice(checkout.getTotalCost)}")
  }

  def getDisplayablePrice(price: Int) = if (price >= 100) {
    s"£${price / 100}" + (if (price % 100 != 0) f".${price%100}%02d" else "")
  } else s"${price}p"

}