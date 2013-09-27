package helpers

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.util.resource.ResourceCollection


object JettyServer extends com.dav.server.servers.Server {
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

trait JettyServer {
  if (!JettyServer.isOn){
    JettyServer.start()
  }
}
