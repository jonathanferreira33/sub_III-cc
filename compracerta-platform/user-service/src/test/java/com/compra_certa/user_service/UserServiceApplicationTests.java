package com.compra_certa.user_service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.rabbitmq.listener.simple.auto-startup=false"
})
class UserServiceApplicationTests {

}
