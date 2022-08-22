//import zio._
//import zio.console._
//
//def myAppLogic = {
//  for {
//    _ <- IO.fail(new RuntimeException("this will fail")) // Task[String]
//    error <- IO.fail(new RuntimeException("this will not fail")).either // ZIO[Any, Nothing, Either[Throwable, String]]
//    _ <- ZIO.succeed(println(s"got error $error"))
//  } yield ()
//}
//
//zio.Runtime.default.unsafeRun(myAppLogic)
//
//// val runtime = zio.Runtime.default
//// object MyApp extends zio.App {
////  final def run(args: List[String]) =
////    myAppLogic.exitCode
////}