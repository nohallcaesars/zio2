# boilerplate-BE

- boilerplate for backend services
- largely based on all the other shiz in this repo

## links

## figuring out the stack

### intellij

- [zio-intellij](https://github.com/zio/zio-intellij)


### http

- sttp stack
  - [sttp client](https://sttp.softwaremill.com/en/latest/)
  - [sttp tapir endpoint descriptions](https://github.com/softwaremill/tapir)
  - [sttp HTTP definitions](https://github.com/softwaremill/sttp-model)
  - [sttp oauth2](https://github.com/ocadotechnology/sttp-oauth2)

### tests

- zio test
  - FYI
    - your going to see a lot of shiz about zio-test, zio.test etc, but if you check the zio docs that shiz looks like it was removed
    - instead: [follow these docs to implement a test version of your zio code](https://zio.dev/version-1.x/overview/overview_testing_effects), and use a normal scala test runner
  - [zio-test-intellij](https://github.com/zio/zio-test-intellij
  - [scalatest runner](https://www.scalatest.org/)
  - [scalacheck property testing framework](https://scalacheck.org/)
  - [sbt test docs](https://www.scala-sbt.org/1.x/docs/Testing.html)