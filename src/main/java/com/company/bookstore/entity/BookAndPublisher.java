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
//@Table(name = BookAndPublisher.TABLE_NAME)
//public class BookAndPublisher implements Serializable {
//
//    public static final String TABLE_NAME = "book_publisher";
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    @ManyToOne
//    private Book book;
//
//    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
//    @ManyToOne
//    private Publisher publisher;
//
//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "status", length = 1, nullable = false)
//    private StatusType statusType;
//
//}
//
