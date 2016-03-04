import org.ddahl.rscala.callback.RClient

object RinScala5 {
  def main(args: Array[String]) = {
    val R = RClient()

    val data = scala.io.Source.fromFile("data/iris.csv").getLines()
    val rows = data.map(_.split(",").toList).toList
    val x = rows.map(_.slice(0,4).map(_.toDouble).toArray).toArray
    val y = rows.map(x => x(4)).toArray
    R.set("x", x)
    R.set("y", y)

    R eval """
        library("e1071")
        y <- unlist(lapply(y, as.factor))

        fit <- svm(x, y)
        p   <- predict(fit, x)
        t   <- table(p, y)
     """.stripMargin

    val confusion_matrix = R.evalD2("t")
    for (rez <- confusion_matrix.toList) {
      println(rez.toList)
    }
  }
}
