/**
  * Created by louisstephancruz on 5/3/17.
  */

import BoardPaths._

import org.scalatest._

class BoardPathSpec extends FunSpec {
  val expectedOutputs = List(((1, 1), 1), ((1, 2), 1), ((1, 3), 1), ((1, 4), 1), ((2, 2), 2), ((2, 3), 3), ((2, 4), 4), ((3, 3), 6), ((3, 4), 10), ((4, 4), 20))
  val expectedDiagonalOutputs = List(((1, 1), 1), ((1, 2), 1), ((1, 3), 1), ((1, 4), 1), ((2, 2), 3), ((2, 3), 5), ((2, 4), 7), ((3, 3), 13), ((3, 4), 25), ((4, 4), 63))

  describe("naivePaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        naivePaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        naivePaths(1, 0)
      }
    }

    expectedOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(naivePaths(x, y) === el._2)
      }
    }
  }

  describe("dynamicPaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        dynamicPaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        dynamicPaths(1, 0)
      }
    }

    expectedOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(dynamicPaths(x, y) === el._2)
      }
    }
  }

  describe("formulaPaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        formulaPaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        formulaPaths(1, 0)
      }
    }

    expectedOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(formulaPaths(x, y) === el._2)
      }
    }
  }

  describe("naiveDiagonalPaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        naiveDiagonalPaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        naiveDiagonalPaths(1, 0)
      }
    }

    expectedDiagonalOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(naiveDiagonalPaths(x, y) === el._2)
      }
    }
  }

  describe("dynamicDiagonalPaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        dynamicDiagonalPaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        dynamicDiagonalPaths(1, 0)
      }
    }

    expectedDiagonalOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(dynamicDiagonalPaths(x, y) === el._2)
      }
    }
  }

  describe("formulaDiagonalPaths") {
    it("throws an exception when the dimensions are less than one") {
      assertThrows[IllegalArgumentException] {
        formulaDiagonalPaths(0, 1)
      }
      assertThrows[IllegalArgumentException] {
        formulaDiagonalPaths(1, 0)
      }
    }

    expectedDiagonalOutputs foreach { el =>
      val (x, y) = el._1
      it("returns the correct answer given an input of (" + x + ", " + y + ")") {
        assert(formulaDiagonalPaths(x, y) === el._2)
      }
    }
  }
}
