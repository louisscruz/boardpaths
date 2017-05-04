def time[T](block: => T): T = {
  val t0 = System.nanoTime()
  val result = block
  val t1 = System.nanoTime()
  val diff = (t1 - t0) / 1000000000.0
  println("Elapsed time: " + diff + "seconds")
  result
}

time {BoardPaths.naivePaths(3, 3)}

time {BoardPaths.dynamicPaths(3, 3)}

time {BoardPaths.formulaPaths(3, 3)}

time {BoardPaths.naiveDiagonalPaths(3, 3)}

time {BoardPaths.dynamicDiagonalPaths(3, 3)}

time {BoardPaths.formulaDiagonalPaths(3, 3)}