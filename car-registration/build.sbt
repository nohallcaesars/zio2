import BuildHelper._

inThisBuild(
  List(
    organization := "nohall.caesars.foss",
    homepage := Some(url("https://zio.github.io/car-registration/")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "nohallcaesars",
        "sraseacllahon",
        "spam@gmail.com",
        url("https://github.com/nohallcaesars/zio2/tree/main/car-registration/car-registration)
      )
    )
)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("fix", "; all compile:scalafix test:scalafix; all scalafmtSbt scalafmtAll")
addCommandAlias("check", "; scalafmtSbtCheck; scalafmtCheckAll; compile:scalafix --check; test:scalafix --check")

addCommandAlias(
  "testJVM",
  ";carRegistrationJVM/test"
)
addCommandAlias(
  "testJS",
  ";carRegistrationJS/test"
)
addCommandAlias(
  "testNative",
  ";carRegistrationNative/test:compile"
)

val zioVersion = "1.0.16"

lazy val root = project
  .in(file("."))
  .settings(
    publish / skip := true,
    unusedCompileDependenciesFilter -= moduleFilter("org.scala-js", "scalajs-library")
  )
  .aggregate(
    carRegistrationJVM,
    carRegistrationJS,
    carRegistrationNative,
    docs
  )

lazy val carRegistration = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .in(file("car-registration"))
  .settings(stdSettings("car-registration"))
  .settings(crossProjectSettings)
  .settings(buildInfoSettings("car.registration"))
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"          % zioVersion,
      "dev.zio" %% "zio-test"     % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt" % zioVersion % Test
    )
  )
  .settings(testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"))
  .enablePlugins(BuildInfoPlugin)

lazy val carRegistrationJS = carRegistration.js
  .settings(jsSettings)
  .settings(libraryDependencies += "dev.zio" %%% "zio-test-sbt" % zioVersion % Test)
  .settings(scalaJSUseMainModuleInitializer := true)

lazy val carRegistrationJVM = carRegistration.jvm
  .settings(dottySettings)
  .settings(libraryDependencies += "dev.zio" %%% "zio-test-sbt" % zioVersion % Test)
  .settings(scalaReflectTestSettings)

lazy val carRegistrationNative = carRegistration.native
  .settings(nativeSettings)

lazy val docs = project
  .in(file("car-registration-docs"))
  .settings(stdSettings("car-registration"))
  .settings(
    publish / skip := true,
    moduleName := "car-registration-docs",
    scalacOptions -= "-Yno-imports",
    scalacOptions -= "-Xfatal-warnings",
    ScalaUnidoc / unidoc / unidocProjectFilter := inProjects(carRegistrationJVM),
    ScalaUnidoc / unidoc / target := (LocalRootProject / baseDirectory).value / "website" / "static" / "api",
    cleanFiles += (ScalaUnidoc / unidoc / target).value,
    docusaurusCreateSite := docusaurusCreateSite.dependsOn(Compile / unidoc).value,
    docusaurusPublishGhpages := docusaurusPublishGhpages.dependsOn(Compile / unidoc).value
  )
  .dependsOn(carRegistrationJVM)
  .enablePlugins(MdocPlugin, DocusaurusPlugin, ScalaUnidocPlugin)
