import scala.annotation.tailrec
import collection.mutable
import Extension._

object Main extends App {
  val cards: Range.Inclusive = 0 to 51

  def shuffle(cards: Seq[Int]): Seq[Int] = {
    val seq = mutable.Seq(cards: _*)
    for (i <- 0 until seq.size - 1) {
      val number = seq(i)
      val index = (Math.random() * 51).toInt
      val switchNumber = seq(index)
      seq(i) = switchNumber
      seq(index) = number
    }
    seq
  }

  @tailrec
  def shuffle2(times: Int, cards: Seq[Int]): Seq[Int] = {
    println(cards.toString())
    if (times == 0) cards else {
      val swap = cards.splitAt((Math.random() * 51).toInt)
      shuffle2(times - 1, swap._2 ++: swap._1)
    }
  }

  shuffle(cards).printlnHalfPassString()
}
