object Extension {

  implicit class RichInt(i: Int) {
    implicit def getSuit: String = i / 13 match {
      case 0 => "\u2660"
      case 1 => "\u2665"
      case 2 => "\u2666"
      case 3 => "\u2663"
    }

    implicit def getNumber: Int = i % 13 + 1

    implicit def halfPass: String = getSuit + getNumber

    implicit def printlnHalfPass(): Unit = println(halfPass)
  }

  implicit class RichList(seq: Seq[Int]) {
    implicit def toHalfPassString: String = seq.map(i => i.halfPass).mkString(", ")

    implicit def printlnHalfPassString(): Unit = println(seq.toHalfPassString)
  }

}
