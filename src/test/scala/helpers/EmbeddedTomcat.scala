package helpers

import org.apache.catalina.startup.Tomcat
import java.io.File

object EmbeddedTomcat {
  val webappDirLocation = "src/main/webapp/"
  val tomcat = new Tomcat()
  var isOn = false

  def start {
    tomcat.setPort(8080)
    tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath())
    println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath())
    tomcat.start()
    isOn = true
  }

  def stop {
    tomcat.stop()
    isOn = false
  }
}

trait EmbeddedTomcat {
  if (!EmbeddedTomcat.isOn){
    EmbeddedTomcat.start
  }
}
