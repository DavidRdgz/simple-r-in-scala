import breeze.linalg.DenseVector
import org.ddahl.rscala.callback.RClient

object RinScala3 {
  def main(args: Array[String]) = {
    val R = RClient()

    R eval """
     df    <- iris
     fit   <- glm(Species ~ Sepal.Width + Petal.Length:Petal.Width, data = df, family= binomial())
     coefs <- fit$coefficients
    """

    val b = DenseVector[Double](R.evalD1("coefs"))
    println(b)
  }
}
