package cukes

import org.scalacheck.Test
import org.scalacheck.util.Pretty.{pretty, Params}
import org.scalacheck.Prop

import scala.collection.JavaConversions._

object PropertyChecker {

  /**
   * Implicit converstion from scala List[Int] to java.util.List[Integer]
   */
  implicit def toIntegerList( lst: List[Int] ) = seqAsJavaList( lst.map( i => i:java.lang.Integer ) )

  /**
   * Checks given property and handles failures with nice output
   * @param property
   */
  def check(property:Prop) {
    val result = Test.check(Test.Parameters.default, property)
    val output = pretty(result, Params(1))
    if (!result.passed) {
      throw new AssertionError(output)
    } else {
      println(output)
    }
  }

}
