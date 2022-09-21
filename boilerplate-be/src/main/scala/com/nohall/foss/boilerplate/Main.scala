package com.nohall.foss.boilerplate

import com.nohall.foss.boilerplate.client.SimpleClient
import zio._
import zio.console._
//import zio.duration.durationInt

import java.io.IOException

object Boilerplate extends App {
  final def run(args: List[String]): URIO[ZEnv, ExitCode] = program.exitCode

  def makeRequest =
    for {
      _ <- SimpleClient.request() >>= (resp => putStrLn(resp.toString))
    } yield ()

  def program: ZIO[ZEnv, IOException, Unit] =
    for {
      _ <- makeRequest
    } yield ()
}
