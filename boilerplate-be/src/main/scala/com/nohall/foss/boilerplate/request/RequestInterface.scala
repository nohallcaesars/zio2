package com.nohall.foss.boilerplate.request

import zio._

final case class Response()

final case class Status()

final case class RequestOpts(timeout: Option[Int], headers: Option[Map[String, String]])

trait Request {
  def send(url: String, opts: RequestOpts): Response
  def cancel(req: Request): Status
}

final object Request {
  def send(url: String, opts: RequestOpts) = ???
  def cancel(req: Request): Status         = ???
}
