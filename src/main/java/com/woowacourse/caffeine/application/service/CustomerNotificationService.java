package com.woowacourse.caffeine.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Service
public class CustomerNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerNotificationService.class);

    private final NotificationInternalService<String> notificationInternalService = new NotificationInternalService<>();

    public ResponseBodyEmitter subscribe(final String customerId) {
        logger.debug("customerId: {}", customerId);

        return notificationInternalService.subscribe(customerId);
    }

    public void send(final String customerId, final String message) {
        logger.debug("customerId: {}, message: {}", customerId, message);

        notificationInternalService.send(customerId, message);
    }

    public void sendAll(String message) {
        logger.debug("message: {}", message);

        notificationInternalService.sendAll(message);
    }
}
