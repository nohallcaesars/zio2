package com.nohall.foss.boilerplate

import zio._
import zio.console._
import java.io.IOException

object Boilerplate extends App {
  final def run(args: List[String]): URIO[ZEnv, ExitCode] = program.exitCode

  def program: ZIO[ZEnv, IOException, Unit] =
    for {
      _ <- putStrLn("what is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
    } yield ()

  // copypasta: zio.zmx didnt work
  //  val diagnosticsLayer: ZLayer[ZEnv, Throwable, Has[Diagnostics]] =
  //    Diagnostics.make("localhost", 1111)
  //
  //  val runtime: Runtime[ZEnv] =
  //    Runtime.default.mapPlatform(_.withSupervisor(ZMXSupervisor))
  //
  //  runtime.unsafeRun(program.provideCustomLayer(diagnosticsLayer))
}
