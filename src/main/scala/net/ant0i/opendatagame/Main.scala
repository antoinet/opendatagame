package net.ant0i.opendatagame

import com.google.inject.Guice
import net.codingwell.scalaguice.InjectorExtensions._
import net.ant0i.opendatagame.dao.mongo.MongoUserDao


object Main extends App {
	val injector = Guice.createInjector(new MyModule)
	val userDao = injector.instance[MongoUserDao]
	
	userDao.getAllUsernames.foreach { x => println(x) }
}