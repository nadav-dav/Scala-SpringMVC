package helpers

import org.apache.catalina.startup.Tomcat
import java.io.File

class EmbeddedTomcat {
  val webappDirLocation = "src/main/webapp/"
  val tomcat = new Tomcat()

  def start {
    tomcat.setPort(8080)
    tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath())
    println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath())
    tomcat.start()
  }

  def stop {
    tomcat.stop()
  }
}
