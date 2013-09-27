package helpers

import org.apache.catalina.startup.Tomcat
import java.io.File
import com.dav.server.servers.Server

object TomcatServer extends Server {
  private val webappDirLocation = "src/main/webapp/"
  private val server = new Tomcat()
  private var isOn = false

  def start() {
    server.setBaseDir("./target")
    server.setPort(8080)
    server.addWebapp("/", new File(webappDirLocation).getAbsolutePath)
    println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath)
    server.start()
    isOn = true
  }

  def stop() {
    server.stop()
    isOn = false
  }
}

trait TomcatServer {
  if (!TomcatServer.isOn){
    TomcatServer.start()
  }
}
