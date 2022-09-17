package com.nohall.foss.boilerplate.client
// @see https://sttp.softwaremill.com/en/latest/backends/zio.html
// @see https://sttp.softwaremill.com/en/latest/quickstart.html
// @see coinranking api: https://developers.coinranking.com/api

import sttp.client3._
import zio.ZIO

final object SimpleClient {

  /** sends a synchronous request, using the default JVM backend
    */
  private val backend = HttpClientSyncBackend()

  def request(
      uri: String = "https://api.coindesk.com/v1/bpi/currentprice.jsonz"
    ): ZIO[Any, Nothing, String] =
    ZIO
      .effectTotal(
        basicRequest
          .get(uri"$uri")
          .send(backend)
      ) >>= (resp =>
      ZIO
        .fromEither(resp.body)
        .fold(
          _ => s" failed: ${resp.code}",
          s => s,
        )
    )
}
