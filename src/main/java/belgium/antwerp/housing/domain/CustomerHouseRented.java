package belgium.antwerp.housing.domain;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "customer_house_rented")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerHouseRented {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;
    @Column(name = "rented_from")
    private Timestamp rentedFrom;
    @Column(name = "rented_to")
    private Timestamp rentedTo;
}
