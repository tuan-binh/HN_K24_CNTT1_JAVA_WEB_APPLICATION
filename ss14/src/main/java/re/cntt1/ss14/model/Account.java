package re.cntt1.ss14.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Khoá chính tự tăng
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Double balance;

}
