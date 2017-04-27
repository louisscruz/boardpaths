def time[T](block: => T): T = {
  val t0 = System.nanoTime()
  val result = block
  val t1 = System.nanoTime()
  val diff = (t1 - t0) / 1000000000.0
  println("Elapsed time: " + diff + "seconds")
  result
}

def naivePaths(x: Int, y: Int): BigInt = (x, y) match {
  case (i, j) if (i < 1 || j < 1) => throw new IllegalArgumentException("input sizes must be greater than zero")
  case (i, j) if (i == 1 || j == 1) => 1
  case _ => naivePaths(x - 1, y) + naivePaths(x, y - 1)
}

time {naivePaths(3, 3)}

def dynamicPaths(x: Int, y: Int): BigInt = {
  if (x < 1 || y < 1) throw new IllegalArgumentException("input sizes must be greater than zero")
  if (x < y) throw new IllegalArgumentException("first argument must be greater than the second argument")

  type Table = Map[Set[Int], BigInt]

  def generateTable(table: Table, i: Int, j: Int): Table = {
    def generateValueAt(table: Table, i: Int, j: Int): BigInt = (i, j) match {
      case (i, j) if (i == 1 || j == 1) => 1
      case _ => table getOrElse (Set(i, j), table(Set(i - 1, j)) + table(Set(i, j - 1)))
    }

    def nextTable(table: Table, i: Int, j: Int): Table =
      table updated(Set(i, j), generateValueAt(table, i, j))

    (i, j) match {
      case (i, j) if (i == x && j == y) => nextTable(table, x, y)
      case (i, j) if (i == x) => generateTable(nextTable(table, 2, j + 1), 2, j + 1)
      case _ => generateTable(nextTable(table, i + 1, j), i + 1, j)
    }
  }

  val startingTable = Map[Set[Int], BigInt]()
  val generatedTable =  generateTable(startingTable, 1, 1)

  generatedTable(Set(x, y))
}

time {dynamicPaths(3, 3)}

def formulaPaths(x: Int, y: Int): BigInt = {
  if (x < 1 || y < 1) throw new IllegalArgumentException("input sizes must be greater than zero")

  def factorial(i: Int): BigInt = {
    def factorialAcc(i: Int, acc: BigInt): BigInt =
      if (i == 1) acc else factorialAcc(i - 1, acc * i)

    factorialAcc(i, 1)
  }

  factorial((x - 1 + y - 1)) / (factorial(x - 1) * factorial(y - 1))
}

time {formulaPaths(3, 3)}

def naiveDiagonalPaths(x: Int, y: Int): BigInt = (x, y) match {
  case (i, j) if (i < 1 || j < 1) => throw new IllegalArgumentException("input sizes must be greater than zero")
  case (i, j) if (i == 1 || j == 1) => 1
  case _ => naiveDiagonalPaths(x - 1, y) + naiveDiagonalPaths(x - 1, y - 1) + naiveDiagonalPaths(x, y - 1)
}

time {naiveDiagonalPaths(3, 3)}

def dynamicDiagonalPaths(x: Int, y: Int): BigInt = {
  if (x < 1 || y < 1) throw new IllegalArgumentException("input sizes must be greater than zero")
  if (x < y) throw new IllegalArgumentException("first argument must be greater than the second argument")

  type Table = Map[Set[Int], BigInt]

  def generateTable(table: Table, i: Int, j: Int): Table = {
    def generateValueAt(table: Table, i: Int, j: Int): BigInt = (i, j) match {
      case (i, j) if (i == 1 || j == 1) => 1
      case _ => table getOrElse (Set(i, j), table(Set(i - 1, j)) + table(Set(i - 1, j - 1)) + table(Set(i, j - 1)))
    }

    def nextTable(table: Table, i: Int, j: Int): Table =
      table updated(Set(i, j), generateValueAt(table, i, j))

    (i, j) match {
      case (i, j) if (i == x && j == y) => nextTable(table, x, y)
      case (i, j) if (i == x) => generateTable(nextTable(table, 1, j + 1), 1, j + 1)
      case _ => generateTable(nextTable(table, i + 1, j), i + 1, j)
    }
  }

  val startingTable = Map[Set[Int], BigInt]().withDefaultValue(BigInt(0))
  val generatedTable = generateTable(startingTable, 0, 1)

  generatedTable(Set(x, y))
}

time {dynamicDiagonalPaths(3, 3)}

def formulaDiagonalPaths(x: Int, y: Int): BigInt = {
  if (x < 1 || y < 1) throw new IllegalArgumentException("input sizes must be greater than zero")
  if (x < y) throw new IllegalArgumentException("first argument must be greater than the second argument")

  def factorial(i: Int): BigInt = {
    def factorialAcc(i: Int, acc: BigInt): BigInt =
      if (i <= 1) acc else factorialAcc(i - 1, acc * i)

    factorialAcc(i, 1)
  }

  def withDiagonals(d: Int): BigInt = {
    val top = factorial(x - 1 + y - 1 - d)
    val bottom = (factorial(d) * factorial(x - 1 - d) * factorial(y - 1 - d))
    top / bottom
  }

  val diagonals = for {
    d <- 0 until x
  } yield withDiagonals(d)

  diagonals.sum
}

time {formulaDiagonalPaths(3, 3)}