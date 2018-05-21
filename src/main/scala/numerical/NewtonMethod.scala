package numerical

object NewtonMethod {
  @scala.annotation.tailrec
  def squareRoot(x: Double, estimate: Option[Double] = None): Double = {
    if (x <= 0) throw new IllegalArgumentException(s"Input value of x = `$x` is illegal. Input value must be >= 1")

    val inputEstimateOrSeed = estimate.getOrElse(x/2)

    val nextEstimate = (inputEstimateOrSeed + x / inputEstimateOrSeed) / 2

    if (x ~ nextEstimate) return nextEstimate.to4DecimalPlaces

    NewtonMethod.squareRoot(x, Option(nextEstimate))
  }

  private implicit class DoubleExtension(x: Double) {
    def to4DecimalPlaces: Double = {
      BigDecimal(x)
        .setScale(4, BigDecimal.RoundingMode.HALF_UP)
        .toDouble
    }

    def ~(y: Double): Boolean = abs(y * y - x) / x < 0.001

    private def abs(d: Double): Double = if (d < 0) -d else d
  }
}
