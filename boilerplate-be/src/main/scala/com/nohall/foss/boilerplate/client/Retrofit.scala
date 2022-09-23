package com.nohall.foss.boilerplate.client

// @see https://sttp.softwaremill.com/en/latest/backends/zio.html
// @see https://sttp.softwaremill.com/en/latest/quickstart.html
// @see coinranking api: https://developers.coinranking.com/api

import com.nohall.foss.boilerplate.json._
import sttp.client3._
import zio._
import zio.json._
import zio.random._

object Retrofit {

  /** sends a synchronous request, using the default JVM backend
    */
  private val backend = HttpClientSyncBackend()
  def url(good: Boolean): String =
    if (good) "https://api.coindesk.com/v1/bpi/currentprice.json"
    else "https://api.coindesk.com/zzz"

  def request(): URIO[Random, Serializable] =
    for {
      bool <- random.nextBoolean
      _    <- ZIO.succeed(println(s"using real url? $bool"))
      decoded <- ZIO
        .effectTotal(
          basicRequest
            .get(uri"${url(bool)}")
            .send(backend)
        ) >>= (resp =>
        ZIO.succeed(
          (if (resp.is200) raw"""${resp.body.merge}""".stripMargin.fromJson[Coindesk]
           else JsonDecoder[String].decodeJson(raw""""failed: ${resp.code}"""")).merge
        )
      )
    } yield decoded

}
