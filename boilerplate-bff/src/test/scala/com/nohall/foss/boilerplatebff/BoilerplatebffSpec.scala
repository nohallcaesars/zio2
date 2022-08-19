package com.nohall.foss.boilerplatebff

import zio.test._
import zio.test.Assertion._
import zhttp.http._

object BoilerplatebffSpec extends DefaultRunnableSpec {
  override def spec: ZSpec[Environment, Failure] = suite("""BoilerplatebffSpec""")(
    testM("200 ok") {
      checkAllM(Gen.fromIterable(List("text", "json"))) { uri =>
        val request = Request(Method.GET, URL(!! / uri))
        assertM(Boilerplatebff.app(request).map(_.status))(equalTo(Status.OK))
      }
    },
  )
}
