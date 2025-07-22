package belgium.antwerp.housing.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "owner_house")
@AllArgsConstructor
@NoArgsConstructor
public class OwnerHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;

}
