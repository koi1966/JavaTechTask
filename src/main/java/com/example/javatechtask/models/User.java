package com.example.javatechtask.models;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "users")
public class User {

    // генерируем id_шники через сиквенс
    private static final String SEQ_NAME = "user_seq";
//    @jakarta.persistence.Id
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
//    @SequenceGenerator(name = SEQ_NAME,sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String roles;
    private boolean valid;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
