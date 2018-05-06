package pl.sda.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer extends AbstractEntity {

    @Column
    protected String address;




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
