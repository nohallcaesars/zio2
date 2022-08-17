package com.nohall.foss.careg

//import io.getquill.context.ZioJdbc._
//import zhttp.http._
//import zhttp.service._
//import zhttp.service.server.ServerChannelFactory
import zio._
import zio.Console._
//import zio.config._
//import zio.stream._
//import com.nohall.foss.careg.api._
//import com.nohall.foss.careg.config.Configuration._
//import com.nohall.foss.careg.healthcheck._
//import com.nohall.foss.careg.repo._
//import com.nohall.foss.careg.service._

//
//object Main extends ZIOAppDefault:
//
//  private val dataSourceLayer = DataSourceLayer.fromPrefix("postgres-db")
//
//  private val repoLayer = ItemRepositoryLive.layer
//
//  private val serviceLayer = ItemServiceLive.layer
//
//  val routes =
//    HttpRoutes.app ++
//    Healthcheck.routes
//
//  val program =
//    for
//      config <- getConfig[ServerConfig]
//      _      <- Server.start(config.port, routes)
//    yield ()
//
//  override val run =
//    program.provide(ServerConfig.layer, serviceLayer, repoLayer, dataSourceLayer)

object Careg extends ZIOAppDefault {
  def run =
    for {
      _ <- printLine("Hello! What is your name?")
      n <- readLine
      _ <- printLine("Hello, " + n + ", good to meet you!")
    } yield ()
}