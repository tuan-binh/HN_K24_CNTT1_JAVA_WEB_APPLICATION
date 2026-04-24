package re.cntt1.ss14.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * fetch type
     *      - LAZY: Lười - Không load dữ liệu luôn
     *      - EAGER: Load dữ liệu lên luôn
     * fetch type default:
     *      - One ở cuối: (EAGER)
     *      - Many ở cuối: (LAZY)
     * cascade
     *      -
     * */
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receive_id")
    private Account receiver;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "message")
    private String message;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

}
