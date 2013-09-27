package helpers

import org.mortbay.jetty.Server
import org.mortbay.resource.ResourceCollection
import org.mortbay.jetty.webapp.WebAppContext

object EmbeddedJetty {
  private val webappDirLocation = "src/main/webapp/"
  private var isOn = false
  private val server : Server = new Server(8080)

  def start() {
    val webContext = new WebAppContext()
    webContext.setContextPath("/")
    val resources = new ResourceCollection(Array[String](webappDirLocation))
    webContext.setBaseResource(resources)
    server.setHandler(webContext)
    server.start()
    isOn = true
  }

  def stop() {
    server.stop()
    isOn = false
  }
}

trait EmbeddedJetty {
  if (!EmbeddedJetty.isOn){
    EmbeddedJetty.start()
  }
}
