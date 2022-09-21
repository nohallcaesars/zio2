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

  val zio               = "dev.zio"                       %% "zio"            % zioV
  val zioJson           = "dev.zio"                       %% "zio-json"       % zioJsonV
  val zioQuill          = "io.getquill"                   %% "quill-jdbc-zio" % zioQuillV
  val sttpClient        = "com.softwaremill.sttp.client3" %% "core"           % sttpClientV
  val sttpClientBackend = "com.softwaremill.sttp.client3" %% "zio1"           % sttpClientV
  val sttpTapir         = "com.softwaremill.sttp.tapir"   %% "tapir-core"     % sttpTapirV
  val sttpModel         = "com.softwaremill.sttp.model"   %% "core"           % sttpModelV
  val sttpShared        = "com.softwaremill.sttp.shared"  %% "core"           % sttpSharedV
  val sttpOauth         = "com.ocadotechnology"           %% "sttp-oauth2"    % sttpOauthV
  // @see https://stackoverflow.com/questions/29311341/sbt-cannot-append-seqobject-to-seqmoduleid
//  val postgres = "org.postgresql" %% "postgresql"     % postgresV

  val commonDeps = Seq(
    zio,
    zioJson,
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
