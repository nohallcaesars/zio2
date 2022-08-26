package com.nohall.foss.boilerplate

import com.nohall.foss.boilerplate.client.SimpleClient
import zio._
import zio.console._
//import zio.duration.durationInt

import java.io.IOException

object Boilerplate extends App {
  final def run(args: List[String]): URIO[ZEnv, ExitCode] = program.exitCode

  def program: ZIO[ZEnv, IOException, Unit] =
    for {
      _ <- putStrLn("what is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
      response = SimpleClient.request()
      _ <- putStrLn(response.toString())
    } yield ()
}
