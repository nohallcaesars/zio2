package com.nohall.foss.boilerplate.json

// @see https://github.com/zio/zio-json#documentation
// @see https://github.com/softwaremill/tapir/blob/master/examples/src/main/scala/sttp/tapir/examples/client/Http4sClientExample.scala
// @see https://zio.dev/guides/tutorials/encode-and-decode-json-data/

//import sttp.tapir.json.zio._
import zio.json._

@jsonDerive case class Time(
    updated: String,
    updatedISO: String,
    updateduk: String)

@jsonDerive case class Currencies(
    code: String,
    symbol: String,
    rate: String,
    description: String,
    rate_float: Float)

@jsonDerive case class BPI(
    USD: Currencies,
    GBP: Currencies,
    EUR: Currencies)

@jsonDerive case class Coindesk(
    time: Time,
    disclaimer: String,
    chartName: String,
    bpi: BPI)

/*
Response(
{
  "time": {
    "updated": "Sep 1, 2022 05:37:00 UTC",
    "updatedISO": "2022-09-01T05:37:00+00:00",
    "updateduk": "Sep 1, 2022 at 06:37 BST"
  },
  "disclaimer": "This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
  "chartName": "Bitcoin",
  "bpi": {
    "USD": {
      "code": "USD",
      "symbol": "&#36;",
      "rate": "20,084.0711",
      "description": "United States Dollar",
      "rate_float": 20084.0711
    },
    "GBP": {
      "code": "GBP",
      "symbol": "&pound;",
      "rate": "16,782.0891",
      "description": "British Pound Sterling",
      "rate_float": 16782.0891
    },
    "EUR": {
      "code": "EUR",
      "symbol": "&euro;",
      "rate": "19,564.8175",
      "description": "Euro",
      "rate_float": 19564.8175
    }
  }
}
 */
