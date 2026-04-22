package cntt1.ss13.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_thinking")
    private Boolean isThinking;

}
