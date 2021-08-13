addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.20.0") // only needed for your JS dependencies, not for Laminar

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.5.0")

resolvers += Resolver.bintrayRepo("oyvindberg", "converter")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta35")

