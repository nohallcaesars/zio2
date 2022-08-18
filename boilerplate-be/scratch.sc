import zio._
import zio.console._

def myAppLogic = {
  for {
    _ <- putStrLn("Hello! What is your name?")
    n <- getStrLn
    _ <- putStrLn("Hello, " + n + ", good to meet you!")
  } yield ()
}

object MyApp extends zio.App {
  final def run(args: List[String]) =
    myAppLogic.exitCode
}

MyApp.run(Nil)
