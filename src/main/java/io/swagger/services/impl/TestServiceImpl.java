package io.swagger.services.impl;

import io.swagger.services.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Override
    public void testService() {
        log.info("Test service is functioning");
    }
}
