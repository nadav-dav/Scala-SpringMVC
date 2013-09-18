package com.dav.server

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping}

@Controller
class HomeController {

  @RequestMapping(Array("/"))
  @ResponseBody
  def home: String = {
    printf("HomeController::home")
    "home/home"
  }
}