import helpers.EmbeddedTomcat
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import scalaj.http.Http

class ControllerTest extends Specification{
  trait Context extends Scope {
    val server = new EmbeddedTomcat
    server.start

    val localServer = "http://localhost:8080"
  }
  "Entry point" should {
     "return the right result" in new Context {
       val result = Http(localServer+"/").asString
       result must beEqualTo("home/home")
     }
  }
}