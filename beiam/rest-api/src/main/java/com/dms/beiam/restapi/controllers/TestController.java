//package com.dms.beiam.restapi.controllers;
//
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//
//    @GetMapping("/public")
//    public String publicEndpoint() {
//        return "Public endpoint";
//    }
//
//    @SecurityRequirement(name = "Bearer Authentication")
//    @GetMapping("/private")
//    public String privateEndpoint() {
//        return "Private endpoint";
//    }
//}
