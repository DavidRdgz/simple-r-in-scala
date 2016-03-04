import org.ddahl.rscala.callback.RClient

object RinScala6 {
  def main(args: Array[String]) = {
    val R = RClient()

    val data = scala.io.Source.fromFile("data/iris.csv").getLines()
    val rows = data.map(_.split(",").toList).toList
    val x = rows.map(_.toArray).toArray
    R.set("df", x)

    R eval """
        library("e1071")
        df <- as.data.frame(df)
        x <- apply(df[,1:4], 1:2, as.numeric)
        y <- factor(df[,5])


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
