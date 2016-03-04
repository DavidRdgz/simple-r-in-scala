import breeze.linalg.DenseVector
import org.ddahl.rscala.callback.RClient

object RinScala2 {
  def main(args: Array[String]) = {
    val R = RClient()

    R eval """
     df    <- iris
     fit <- glm(Species ~ . , data = df, family= binomial())
     coefs <- fit$coefficients
    """

    val a = DenseVector[Double](R.evalD1("coefs"))
    println(a)
  }
}
