/**
 *
 */
package net.ant0i.opendatagame.dao.mongo

import net.ant0i.opendatagame.dao.UserDao
import net.ant0i.opendatagame.domain.user.User
import com.mongodb.casbah.MongoDB
import com.mongodb.casbah.commons.MongoDBObject
import com.google.inject.Inject

/**
 * User DAO for MongoDB.
 */
class MongoUserDao @Inject() (val mongoDB: MongoDB) extends UserDao {
  
  val MongoCol = mongoDB("test_data")
  val UsernameKey = "user"
  

  def getUserByName(username: String): Option[User] = {
    val query = MongoDBObject(UsernameKey -> username)
    MongoCol.findOne(query) match {
      case None => None
      case Some(x) => {
       val y = x.asInstanceOf[MongoDBObject]
       Some(new User(y.as[String]("user"), y.as[String]("email")))
      }
    }
    Some(new User("johndoe", "johndoe@example.com"))
  }
  
  def getAllUsernames: Iterator[String] = {
    val query = MongoDBObject.empty
    val fields = MongoDBObject(UsernameKey -> 1)
    MongoCol.find(query, fields).map { x =>
      x.toString()
    }
  }
}