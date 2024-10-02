package com.example.server.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Log4jEntiry {
    private final Logger logger = LogManager.getLogger(Log4jEntiry.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void log4jInfo(String message) {
        logger.info(message);
    }

    public void log4jDebug(String message) {
        logger.debug(message);
    }

    public void log4jError(String message) {
        logger.error(message);
    }

    public void log4jEntity(Object entity) {
        try {
            String json = objectMapper.writeValueAsString(entity);
            logger.info(json);
        } catch (Exception e) {
            logger.error("Error serializing entity to JSON", e);
        }
    }

    public void log4jEntitys(Object entities) {
        try {
            String json = objectMapper.writeValueAsString(entities);
            logger.info("Entities: {}", json);
        } catch (JsonProcessingException e) {
            logger.error("Error converting entity to JSON", e);
        }
    }
}
