package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.Message;

import java.sql.ResultSet;
import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/messages/*")
@RestController
public class MessageController {
    @Setter(onMethod_ = @Autowired)
    private JdbcTemplate template;


    // To test DQL query with Spring JDBC
    @GetMapping
    List<Message> getAllMessages() {
        log.trace("getAllMessages() invoked.");

        String DQL = " SELECT id, text FROM message ORDER BY id DESC ";
        return this.template.<Message>query(DQL, (rs , i) -> {

            Message message = new Message();

            message.setId(rs.getInt("id"));
            message.setText(rs.getString("text"));

            return message;
        });


    } // getAllMessages


    // To test DML query with Spring JDBC
    @PostMapping(params = {"message"})
    void postMessage(Message message) {
        log.trace("postMessage({}) invoked.", message);

        String DML = "INSERT INTO message (text) VALUES (?)";
        int affectedRows = this.template.update(DML, message.getMessage());
        log.info("\t affectedRows: {}", affectedRows);


    } // postMessage


} // end class
