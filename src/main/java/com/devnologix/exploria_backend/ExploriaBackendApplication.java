package com.devnologix.exploria_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExploriaBackendApplication {

  // @Value("${NAME:Exploria}")
  // String name;

  // @RestController
  // class HelloworldController {
  //   @GetMapping("/")
  //   String hello() {
  //     return "Hello " + name + "!";
  //   }
  // }

  public static void main(String[] args) {
    SpringApplication.run(ExploriaBackendApplication.class, args);
  }

}
