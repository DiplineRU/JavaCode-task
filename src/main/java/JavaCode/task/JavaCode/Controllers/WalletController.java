package JavaCode.task.JavaCode.Controllers;

import JavaCode.task.JavaCode.Model.Wallet;
import JavaCode.task.JavaCode.Service.WalletService;
import JavaCode.task.JavaCode.Model.WalletTransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<?> processTransaction(@RequestBody WalletTransactionRequest request) {
        try {
            Wallet wallet = walletService.processTransaction(request.getWalletId(), request.getOperationType(), request.getAmount());
            return ResponseEntity.ok(wallet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<?> getWallet(@PathVariable UUID walletId) {
        try {
            Wallet wallet = walletService.getWallet(walletId);
            return ResponseEntity.ok(wallet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
