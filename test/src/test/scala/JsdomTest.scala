import scala.scalajs.js
import utest._

object JsdomTest extends TestSuite {

  override def tests = Tests {
    "document" - org.scalajs.dom.document
  }
}
