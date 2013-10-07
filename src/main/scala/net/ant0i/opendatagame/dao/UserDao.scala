package net.ant0i.opendatagame.dao

import net.ant0i.opendatagame.domain.user.User

/**
 * Data access object for users.
 */
trait UserDao {
  
  /**
   * Retrieves a user from the persistence layer.
   * 
   * @param username The user to retrieve.
   * @return The user or [[None]] if not found.
   */
  def getUserByName (username: String): Option[User]
  
  /**
   * Returns a list of all usernames.
   * 
   * @return list of all usernames.
   */
  def getAllUsernames : Iterator[String]
}