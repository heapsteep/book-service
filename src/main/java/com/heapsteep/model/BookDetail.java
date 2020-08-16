package com.heapsteep.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter @Getter
public class BookDetail {	
    private String bookTitle;    
    private int port;
}