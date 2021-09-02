import scala.scalajs.js
import utest._

object FirefoxTest extends TestSuite {

  override def tests = Tests {
    "document" - org.scalajs.dom.document
  }
}
