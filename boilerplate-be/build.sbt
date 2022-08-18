// static
val appName = "boilerplate-be"

// deps
val zioVersion    = "1.0.16"
val zioZmxVersion = "0.0.13"

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        name         := appName,
        organization := s"com.nohall.foss.$appName",
        version      := "0.0.1",
        scalaVersion := "2.13.8",
      )
    ),
    name := appName,
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"     % zioVersion,
      "dev.zio" %% "zio-zmx" % zioZmxVersion,
    ),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
  )
  .enablePlugins(JavaAppPackaging)
