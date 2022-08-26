package com.nohall.foss.boilerplate.client
// @see https://sttp.softwaremill.com/en/latest/backends/zio.html
// @see https://sttp.softwaremill.com/en/latest/quickstart.html

import sttp.client3._

final object SimpleClient {
  private val backend = HttpClientSyncBackend()

  def request(uri: String = "https://api.coindesk.com/v1/bpi/currentprice.json") =
    basicRequest
      .get(uri"$uri")
      .send(backend)
}
