package com.dav.server

import helpers.JettyServer
import com.dav.server.servers.Server


object Main{
  def main(args: Array[String]) {
    val server :Server = JettyServer
    server.start()
    println("-----STARTING SERVER-----")
  }
}
