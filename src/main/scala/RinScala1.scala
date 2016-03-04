import org.ddahl.rscala.callback.RClient

object RinScala1 {
  def main(args: Array[String]) = {
    val R = RClient()

    R eval """
       x <- 1
    """.stripMargin

    val x = R.get("x")
    println(x)
  }
}
