/**
 *
 */
package net.ant0i.opendatagame

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import com.mongodb.casbah.MongoDB
import com.google.inject.Provides
import com.mongodb.casbah.MongoClient

/**
 * Defines Guice Bindings for this application.
 */
class MyModule extends AbstractModule with ScalaModule {

	def configure {
//	  bind[MongoDB]
	}
	
	@Provides
	def provideMongoDB: MongoDB = MongoClient()("casbah_test")
}