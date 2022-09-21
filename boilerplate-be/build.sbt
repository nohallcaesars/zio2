// @see https://github.com/zio/zio-intellij/blob/idea221.x/build.sbt
// @see https://github.com/sbt/sbt/blob/1.7.x/build.sbt

import Dependencies._

// force reload on any changes to sbt build files
Global / onChangedBuildSource := ReloadOnSourceChanges

// ThisBuild settings take lower precedence,
// but can be shared across the multi projects.
ThisBuild / version       := "0.0.1"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / scalaVersion  := "2.13.8"
ThisBuild / organization  := "com.nohall.foss.boilerplate"
ThisBuild / description   := "scala 2, zio 1 starter kit for backend apps"
ThisBuild / homepage := Some(url("https://github.com/nohallcaesars/zio2/tree/main/boilerplate-be"))
ThisBuild / developers := List(
  Developer("nohall", "noah hall", "nohall@caesars.com", url("https://github.com/nohallcaesars"))
)

ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots")

// testing
ThisBuild / turbo         := true
ThisBuild / usePipelining := true

// keeping
Compile / run / fork := true // forks sbt on run/runMain so ~run works as expected

lazy val root = newProject("BoilerplateBE", file("."))
  //  .aggregate(beCore) // replay cmds
  //  .dependsOn(beCore) // required subprojects
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= commonDeps
    //    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
  )

def newProject(projectName: String, base: File): Project =
  Project(projectName, base).settings(
    name          := projectName,
    onLoadMessage := s"$projectName has been loaded",
    // @see https://docs.scala-lang.org/overviews/compiler-options/index.html
    scalacOptions ++= Seq(
      "-encoding",
      "utf8",
      "-Ymacro-annotations",
      "-deprecation",
      "-explaintypes",
      "-feature",
      "-language:experimental.macros",
      "-opt:allow-skip-class-loading",
      "-Xcheckinit",
//      "-Xdev",
      "-Xlint",
    ),
  )
