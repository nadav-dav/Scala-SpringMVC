package com.dav.server

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping}
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.XmlWebApplicationContext

@Controller
class HomeController {

  @RequestMapping(Array("/"))
  @ResponseBody
  def home: String = {
    println("HomeController::home")
    "home/home"
  }
}