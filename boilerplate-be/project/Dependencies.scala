// @see https://github.com/dream11/zio-http/blob/main/project/Dependencies.scala
// @see https://www.scala-sbt.org/1.x/docs/Organizing-Build.html
// @see https://github.com/sbt/sbt/blob/1.7.x/project/Dependencies.scala

import sbt._
//import Keys._

// make sure to check the fkn releases support your scala version
object Dependencies {
  lazy val zioV        = "1.0.16"
  lazy val zioJsonV    = "0.2.0-M4" // last support for zio 1
  lazy val zioQuillV   = "4.1.1-SNAPSHOT"
  lazy val postgresV   = "42.3.1"
  lazy val sttpClientV = "3.7.6"
  lazy val sttpTapirV  = "1.0.6"
  lazy val sttpModelV  = "1.5.0"
  lazy val sttpSharedV = "1.3.7"
  lazy val sttpOauthV  = "0.15.0"

//  lazy val tapirZioJson      = "com.softwaremill.sttp.tapir"   %% "tapir-json-zio" % "0.18.3"
  lazy val zio               = "dev.zio"                       %% "zio"             % zioV
  lazy val zioJson           = "dev.zio"                       %% "zio-json"        % zioJsonV
  lazy val zioJsonMacros     = "dev.zio"                       %% "zio-json-macros" % zioJsonV
  lazy val zioQuill          = "io.getquill"                   %% "quill-jdbc-zio"  % zioQuillV
  lazy val sttpClient        = "com.softwaremill.sttp.client3" %% "core"            % sttpClientV
  lazy val sttpClientBackend = "com.softwaremill.sttp.client3" %% "zio1"            % sttpClientV
  lazy val sttpTapir         = "com.softwaremill.sttp.tapir"   %% "tapir-core"      % sttpTapirV
  lazy val sttpModel         = "com.softwaremill.sttp.model"   %% "core"            % sttpModelV
  lazy val sttpShared        = "com.softwaremill.sttp.shared"  %% "core"            % sttpSharedV
  lazy val sttpOauth         = "com.ocadotechnology"           %% "sttp-oauth2"     % sttpOauthV
  // @see https://stackoverflow.com/questions/29311341/sbt-cannot-append-seqobject-to-seqmoduleid
//  val postgres = "org.postgresql" %% "postgresql"     % postgresV

  lazy val commonDeps = Seq(
    zio,
    zioJson,
    zioJsonMacros,
//    tapirZioJson,
    sttpClient,
    sttpClientBackend,
    sttpTapir,
    sttpModel,
    sttpShared,
    sttpOauth,
//    zioQuill,
//    postgresV,
  )
}
