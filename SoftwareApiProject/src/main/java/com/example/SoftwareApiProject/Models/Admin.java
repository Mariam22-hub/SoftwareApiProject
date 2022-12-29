package com.example.SoftwareApiProject.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class Admin {

    String name = "admin";
    String password = "admin";



}
