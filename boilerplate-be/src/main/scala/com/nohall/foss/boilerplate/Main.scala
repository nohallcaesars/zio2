package com.nohall.foss.boilerplate

import zio._

import java.io.IOException

object Boilerplate extends zio.App {
  final def run(args: List[String]): URIO[console.Console, ExitCode] = pipeline.exitCode

  def pipeline: ZIO[console.Console, IOException, Unit] =
    for {
      _ <- console.putStrLn("what is your name?")
      n <- console.getStrLn
      _ <- console.putStrLn("Hello, " + n + ", good to meet you!")
    } yield ()
}
