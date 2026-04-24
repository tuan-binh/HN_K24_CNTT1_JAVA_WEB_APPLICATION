package re.cntt1.ss14.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.cntt1.ss14.repository.ITransferRepository;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TransferController {
    private final ITransferRepository transferRepository;

    @GetMapping
    public String formBanking() {
        return "mama_bank";
    }

    @PostMapping("/papa_bank")
    public String papaBank(
            @RequestParam(name = "senderId") Long senderId,
            @RequestParam(name = "receiveId") Long receiveId,
            @RequestParam(name = "amount") Double amount
    ) {
        transferRepository.banking(senderId,receiveId,amount);
        return "redirect:/histories";
    }

    @GetMapping("/histories")
    public String histories(Model model) {
        model.addAttribute(
                "histories",
                transferRepository.histories()
        );
        return "histories";
    }

}
