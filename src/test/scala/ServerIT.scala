import helpers.JettyServer
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import scalaj.http.Http

class ServerIT extends Specification with JettyServer{
  trait Context extends Scope {
    val localServer = "http://localhost:8080"
  }
  "Entry point" should {
     "return the right result" in new Context {
       val result = Http(localServer+"/").asString
       result must beEqualTo("home/home")
     }

    "have a mapped resources folder" in new Context {
      val result = Http(localServer+"/resources/server.png")
      result.responseCode must beEqualTo(200)
    }
  }
}
