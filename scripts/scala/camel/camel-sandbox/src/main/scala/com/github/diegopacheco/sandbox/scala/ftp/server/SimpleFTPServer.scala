package com.github.diegopacheco.sandbox.scala.ftp.server

import org.apache.ftpserver.FtpServerFactory
import org.apache.ftpserver.listener.ListenerFactory
import org.apache.ftpserver.FtpServer
import org.apache.ftpserver.ftplet.FileSystemFactory
import org.apache.ftpserver.filesystem.nativefs.NativeFileSystemFactory
import org.apache.ftpserver.ftplet.User
import org.apache.ftpserver.usermanager.impl.BaseUser
import org.apache.ftpserver.ftplet.FileSystemView
import org.apache.ftpserver.ftplet.UserManager
import org.apache.ftpserver.usermanager.impl.PropertiesUserManager
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory
import java.io.File
import org.apache.ftpserver.usermanager.PasswordEncryptor
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor
import org.apache.ftpserver.listener.Listener

object SimpleFTPServer extends App{
	
    def start():Unit = {
        val serverFactory:FtpServerFactory = new FtpServerFactory()

        val factory:ListenerFactory = new ListenerFactory()
        factory.setPort(21)
        serverFactory.addListener("default", factory.createListener())
        
        val userManagerFactory:PropertiesUserManagerFactory  = new PropertiesUserManagerFactory()
        userManagerFactory.setFile(new File("myusers.properties"))
        userManagerFactory.setAdminName("diego")
        userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor())
        
        serverFactory.setUserManager(userManagerFactory.createUserManager())

        val server:FtpServer = serverFactory.createServer()
        server.start()
        
    }
    
    SimpleFTPServer.start
    
}