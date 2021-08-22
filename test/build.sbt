scalaVersion := "2.13.6"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "1.1.0",
  "com.lihaoyi" %%% "utest" % "0.7.10" % Test,
)

testFrameworks := new TestFramework("utest.runner.Framework") :: Nil

jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv