package com.nohall.foss.boilerplate.client
// @see https://sttp.softwaremill.com/en/latest/backends/zio.html
// @see https://sttp.softwaremill.com/en/latest/quickstart.html
// @see coinranking api: https://developers.coinranking.com/api

import sttp.client3._
import zio.random._
import zio.{ URIO, ZIO, random }

final object SimpleClient {

  /** sends a synchronous request, using the default JVM backend
    */
  private val backend = HttpClientSyncBackend()
  def url(good: Boolean): String =
    if (good) "https://api.coindesk.com/v1/bpi/currentprice.json"
    else "https://api.coindesk.com/zzz"

  def request(): URIO[Random, String] =
    for {
      bool <- random.nextBoolean
      _    <- ZIO.succeed(println(s"using real url? $bool"))
      result <- ZIO
        .effectTotal(
          basicRequest
            .get(uri"${url(bool)}")
            .send(backend)
        ) >>= (resp =>
        ZIO
          .fromEither(resp.body)
          .fold(
            _ => s" failed: ${resp.code}",
            s => s,
          )
      )
    } yield result

}
