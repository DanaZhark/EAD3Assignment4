package ead3.assignment3;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name = "customer")
// Define a sequence - might also be in another class:
@SequenceGenerator(name="seq", initialValue=2, allocationSize=100)
public class Customer {
    //mark id as primary key
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    //defining first_name as column name
    @Column
    private String first_name;
    //defining last_name as column name
    @Column
    private String last_name;
    //defining membership as column name
    @Column
    private String membership;

    public Customer() {

    }

    public Customer(String first_name, String last_name, String membership) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
