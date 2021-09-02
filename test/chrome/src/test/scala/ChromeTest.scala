import org.scalajs.dom._
import scala.scalajs.js
import utest._

object ChromeTest extends TestSuite {

  override def tests = Tests {
    "userAgent" - window.navigator.userAgent
  }
}
