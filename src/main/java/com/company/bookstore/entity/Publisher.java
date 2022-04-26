//package com.company.bookstore.entity;
//
//import com.company.bookstore.enumeration.StatusType;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = Publisher.TABLE_NAME)
//public class Publisher implements Serializable {
//
//    public static final String TABLE_NAME = "publisher";
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String surname;
//
//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status", length = 1, nullable = false)
//    private StatusType statusType;
//
//}
//
