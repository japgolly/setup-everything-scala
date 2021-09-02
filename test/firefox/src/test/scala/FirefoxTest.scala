import org.scalajs.dom._
import scala.scalajs.js
import utest._

object FirefoxTest extends TestSuite {

  override def tests = Tests {
    "userAgent" - window.navigator.userAgent
  }
}
