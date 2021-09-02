import java.util.concurrent.TimeUnit
import org.openqa.selenium.{Capabilities, WebDriver}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxOptions, FirefoxProfile}
import org.openqa.selenium.remote.server.{DriverFactory, DriverProvider}
import org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv
import org.scalajs.jsenv.selenium.SeleniumJSEnv

scalaVersion := "2.13.6"

def testProject: Project => Project = _
  .enablePlugins(ScalaJSPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.2.0",
      "com.lihaoyi" %%% "utest" % "0.7.10" % Test,
    ),
    testFrameworks := new TestFramework("utest.runner.Framework") :: Nil,
  )

lazy val root = project
  .in(file("."))
  .aggregate(
    chrome,
    firefox,
    nodeJsdom,
  )

lazy val chrome = project
  .configure(testProject)
  .settings(
    jsEnv := {
      System.setProperty("webdriver.chrome.silentOutput", "true")
      val o = new ChromeOptions()
      o.setHeadless(true)
      o.addArguments("--allow-file-access-from-files")
      val df = new DriverFactory {
        private[this] val default = SeleniumJSEnv.Config().driverFactory
        override def newInstance(c: Capabilities): WebDriver = {
          val d = default.newInstance(c).asInstanceOf[ChromeDriver]
          d.manage.timeouts.pageLoadTimeout(1, TimeUnit.MINUTES)
          d.manage.timeouts.setScriptTimeout(1, TimeUnit.MINUTES)
          d
        }
        override def registerDriverProvider(p: DriverProvider): Unit =
          default.registerDriverProvider(p)
      }
      new SeleniumJSEnv(o, SeleniumJSEnv.Config().withDriverFactory(df))
    },
  )

lazy val firefox = project
  .configure(testProject)
  .settings(
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
  )

lazy val nodeJsdom = project
  .in(file("node-jsdom"))
  .configure(testProject)
  .settings(
    jsEnv := {
      val p = new FirefoxProfile()
      p.setPreference("privacy.file_unique_origin", false)
      val o = new FirefoxOptions()
      o.setProfile(p)
      o.setHeadless(true)
      new SeleniumJSEnv(o)
    },
  )
