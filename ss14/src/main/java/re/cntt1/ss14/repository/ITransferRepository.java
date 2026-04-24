package re.cntt1.ss14.repository;

import re.cntt1.ss14.model.Transfer;

import java.util.List;

public interface ITransferRepository {

    void banking(Long senderId, Long receiveId, Double amount);

    List<Transfer> histories();

}
