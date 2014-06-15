package cukes

import cucumber.api.scala.{EN, ScalaDsl}
import example.Rating
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import cukes.PropertyChecker.{check, toIntegerList}

class RatingSteps extends ScalaDsl with EN {

  var lower = 0
  var upper = 0

  Given("""^a piece of content has received many ratings between (\d+) and (\d+)$"""){ (from:Int, to:Int) =>
    lower = from
    upper = to
  }

  When("""^I view that content$"""){ () =>
    // do nothing
  }

  Then("""^I want to see the average rating$"""){ () =>

    // generator that picks from sample of numbers between (lower, upper)
    val rating = Gen.choose(lower, upper)

    // generates random list of ratings generated from above generator
    val ratings = Gen.listOf(rating)

    // for every set of ratings, an accurate average should be returned
    val property = forAll(ratings) { ratings =>
      val expected = if (ratings.isEmpty) null else ratings.sum / ratings.length
      Rating.average(ratings) == expected
    }
    check(property)

  }

}
