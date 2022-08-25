package com.nohall.foss.boilerplate

import zio._
import zio.console._
import zio.duration.durationInt

import java.io.IOException

object Boilerplate extends App {
  final def run(args: List[String]): URIO[ZEnv, ExitCode] = program.exitCode

  def program: ZIO[ZEnv, IOException, Unit] =
    for {
      _ <- putStrLn("what is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
      fiber <- putStrLn("Working on the first job")
        .schedule(Schedule.fixed(1.seconds))
        .ensuring {
          (putStrLn(
            "Finalizing or releasing a resource that is time-consuming"
          ) *> ZIO.sleep(7.seconds)).orDie
        }
        .fork
      _ <- fiber.interrupt.delay(4.seconds)
      _ <- putStrLn(
        "Starting another task when the interruption of the previous task finished"
      )
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
