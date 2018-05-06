package pl.sda.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "documents", cascade = CascadeType.ALL)
    private Set<Sell> sellSet ;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customers;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Sell> getSellSet() {
        return sellSet;
    }

    public void setSellSet(Set<Sell> sellSet) {
        this.sellSet = sellSet;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
