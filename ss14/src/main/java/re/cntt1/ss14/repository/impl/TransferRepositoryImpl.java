package re.cntt1.ss14.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import re.cntt1.ss14.model.Account;
import re.cntt1.ss14.model.Transfer;
import re.cntt1.ss14.repository.ITransferRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class TransferRepositoryImpl implements ITransferRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void banking(Long senderId, Long receiveId, Double amount) {
        // 1. Mở phiên session
        Session session = sessionFactory.getCurrentSession();

//        Transaction tx = session.beginTransaction();

        // 2. Tìm ra đối tượng sender và receive
        Account sender = session.get(Account.class, senderId);
        Account receiver = session.get(Account.class, receiveId);

        // 3. Kiểm tra có đủ tiền hay không
        if (amount < 0) {
            System.err.println("Số tiền chuyển không hợp lệ!!!");
//            tx.rollback();
            return;
        }
        if (sender.getBalance() < amount) {
            System.err.println("Số dư không đủ");
//            tx.rollback();
            return;
        }

        // 4. Cập nhật tiền trong tài khoản (sender -) (receive +)
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        // 5 Lưu vào database
        session.merge(sender);
        session.merge(receiver);

        // Phải tạo lịch sử giao dịch
        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setSender(sender);
        transfer.setReceiver(receiver);
        transfer.setMessage("Tôi đang cần gacha genshin impact");
        transfer.setTransferDate(LocalDateTime.now());
        session.persist(transfer);

//        tx.commit();

        // 6. Áp dụng Transaction
        /**
         * 1. Bắt đầu Transaction: beginTransaction
         *
         * 2. commit khi thành công: commit()
         *
         * 3. nếu lỗi: rollback()
         * */
    }

    @Override
    public List<Transfer> histories() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Transfer", Transfer.class).list();
    }
}
