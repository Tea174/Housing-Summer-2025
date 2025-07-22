package belgium.antwerp.housing.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table(name = "house")
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<OwnerHouse> ownerHouses;
    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<CustomerHouseRented> customerHouseRented;
}
