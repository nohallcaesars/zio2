package com.nohall.foss.boilerplate

import zio._
import zio.console._
import java.io.IOException

<<<<<<< HEAD
object Boilerplate extends App {
  final def run(args: List[String]): URIO[ZEnv, ExitCode] = program.exitCode

  def program: ZIO[ZEnv, IOException, Unit] =
||||||| parent of 5e668d4 (fix boilerplate)
object Boilerplate extends ZIOAppDefault {
  def run =
=======
import java.io.IOException

object Boilerplate extends zio.App {
  final def run(args: List[String]): URIO[console.Console, ExitCode] = pipeline.exitCode

  def pipeline: ZIO[console.Console, IOException, Unit] =
>>>>>>> 5e668d4 (fix boilerplate)
    for {
<<<<<<< HEAD
      _ <- putStrLn("what is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
||||||| parent of 5e668d4 (fix boilerplate)
      _ <- Console.printLine("Hello! What is your name?")
      n <- Console.readLine
      _ <- Console.printLine("Hello, " + n + ", good to meet you!")
=======
      _ <- console.putStrLn("what is your name?")
      n <- console.getStrLn
      _ <- console.putStrLn("Hello, " + n + ", good to meet you!")
>>>>>>> 5e668d4 (fix boilerplate)
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
