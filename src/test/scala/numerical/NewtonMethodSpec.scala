package numerical

import org.scalatest.FunSuite

class NewtonMethodSpec extends FunSuite {
  test("returns error for 0") {
    intercept[IllegalArgumentException] {
      NewtonMethod.squareRoot(0)
    }
  }

  test("returns error for negative number") {
    intercept[IllegalArgumentException] {
      NewtonMethod.squareRoot(-1)
    }
  }

  test("returns the root of square numbers: 4") {
    assert(NewtonMethod.squareRoot(4) ~ 2)
  }

  test("returns the root of square numbers: 625") {
    assert(NewtonMethod.squareRoot(625) ~ 25)
  }

  test("returns the root of 2 to 4 dp") {
    assert(NewtonMethod.squareRoot(2) ~ 1.4142)
  }

  test("returns the root of 2.1 to 4 dp") {
    assert(NewtonMethod.squareRoot(2.1) ~ 1.4491)
  }

  test("returns the root of 0.0001 to 4 dp") {
    assert(NewtonMethod.squareRoot(0.0001) ~ 0.01)
  }

  test("returns the root of 1e-6 to 4 dp") {
    assert(NewtonMethod.squareRoot(1e-6) ~ 1e-3)
  }

  test("returns the root of 1e-20 to 4 dp") {
    assert(NewtonMethod.squareRoot(1e-20) ~ 1e-10)
  }

  test("returns the root of 1e20 to 4 dp") {
    assert(NewtonMethod.squareRoot(1e20) ~ 1e10)
  }

  private implicit class DoubleExtension(x: Double) {
    def ~(y: Double): Boolean = {
      y - x <= 0.0001
    }
  }
}
