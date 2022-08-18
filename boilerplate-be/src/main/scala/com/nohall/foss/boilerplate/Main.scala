package com.nohall.foss.boilerplate

import zio._

object Boilerplate extends ZIOAppDefault {
  def run =
    for {
      _ <- Console.printLine("Hello! What is your name?")
      n <- Console.readLine
      _ <- Console.printLine("Hello, " + n + ", good to meet you!")
    } yield ()
}
