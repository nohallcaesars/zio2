import Dependencies._

// build settings
ThisBuild / organization := s"com.nohall.foss.boilerplate"
ThisBuild / version      := "0.0.1"
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots")
Compile / run / fork := true // forks sbt on run/runMain so ~run works as expected

// main project
lazy val root = (project in file("."))
  //  .aggregate(beCore) // replay cmds
  //  .dependsOn(beCore) // required subprojects
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "BoilerplateBE",
    libraryDependencies ++= commonDeps,
    //    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
  )

// additional services
// @see https://github.com/pbassiner/sbt-multi-project-example
//lazy val beCore = (project in file("core"))
//  .settings(
//    name := "BE Core",
//    libraryDependencies ++= Seq(zio, zioZmx),
//  )
