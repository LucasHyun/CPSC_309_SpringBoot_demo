package demo

import org.springframework.stereotype.Service
import org.springframework.data.repository.findByIdOrNull
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import java.util.UUID
import java.util.*


//@Service
//class MessageService(private val db: JdbcTemplate) {
//    fun findMessages(): List<Message> = db.query("select * from messages") {response, _ ->
//        Message(response.getString("id"), response.getString("text"))
//    }
//    fun save(message: Message): Message {
//        db.update(
//            "insert into messages values (?, ?)",
//            message.id, message.text
//        )
//        return message
//    }
//}

//@Service
//class MessageService(private val db: JdbcTemplate) {
//    fun findMessages(): List<Message> = db.query("select * from messages") {response, _ ->
//        Message(response.getString("id"), response.getString("text"))
//    }
//
//    fun findMessageById(id: String): Message? = db.query("select * from messages where id = ?", id) { response, _ -> Message(response.getString("id"), response.getString("text"))
//    }.singleOrNull()
//
//
//    fun save(message: Message): Message {
//        val id = message.id ?: UUID.randomUUID().toString()
//        db.update(
//            "insert into messages values (?, ?)",
//            id, message.text
//        )
//        return message.copy(id = id)
//    }
//}

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)

    fun save(message: Message): Message = db.save(message)
}