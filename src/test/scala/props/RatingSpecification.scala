package props

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import example.Rating

import scala.collection.JavaConversions._

object RatingSpecification extends Properties("example.Rating") {

  /**
   * Implicit converstion from scala List[Int] to java.util.List[Integer]
   */
  implicit def toIntegerList( lst: List[Int] ) = seqAsJavaList( lst.map( i => i:java.lang.Integer ) )

  property("average") = forAll { (ratings:List[Int]) =>
    Rating.average(ratings) == (ratings.sum / ratings.length)
  }

}
