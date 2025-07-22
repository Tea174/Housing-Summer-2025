package belgium.antwerp.housing.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<CustomerHouseRented> customerHouseRented;
    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<OwnerHouse> ownerHouses;
}
