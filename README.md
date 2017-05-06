# Board Paths

This repository contains the code used in [this blog post][blog post] on [louiscruz.io][louiscruz.io].

The `BoardPaths` package solves two versions of the same problem in which one must calculate the total number of possible paths a game piece can take to move from one diagonal of a chess board to its opposite:

* In the first version, the game piece may only move right and down.
* In the second version, the game piece may move right, down, or diagonally.

[blog post]: http://louiscruz.io/board-paths
[louiscruz.io]: http://louiscruz.io

## Package

The package is located [here][package]. This is the code that is used in the blog post.

[package]: ./src/main/scala-2.12/BoardPaths/package.scala

## Benchmarking

The worksheet used for (very unscientific) benchmarking is [here][benchmarking].

[benchmarking]: ./src/main/scala-2.12/paths.sc

## Tests

The tests cover:

* Input validation
* Output correctness up to a board of size four in both dimensions
* Output result symmetry up to a board of size four in both dimensions (e.g. the number of paths for a board of size 2 x 3 is equal to those of a board of size 3 x 2)

The tests are located [here][tests].

[tests]: ./src/test/scala-2.12/BoardPathSpec.scala