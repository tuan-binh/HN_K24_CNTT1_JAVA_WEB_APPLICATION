package cntt1.ss13.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "identity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cccd;

    // Has - a
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    /**
     * 1 - 1
     * n - 1
     * n - n
     *      - 1 khoá chính và 2 khoá ngoại
     *      - 2 khoá chính phức hợp nhưng kèm thêm thuộc tính
     *      - 2 khoá chính phức hợp có 1 cái thôi (ko có thuộc tính phụ)
     * */

}
