import org.ddahl.rscala.callback.RClient

object RinScala4 {
  def main(args: Array[String]) = {
    val R = RClient()

    R eval """
        library("e1071")
        df <- iris
        x  <- iris[,1:4]
        y  <- iris[,5]
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
