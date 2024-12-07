package JavaCode.task.JavaCode.Service;

import JavaCode.task.JavaCode.Model.Wallet;
import JavaCode.task.JavaCode.Service.ServiceInterface.WalletRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public synchronized Wallet processTransaction(UUID walletId, String operationType, long amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));

        if ("DEPOSIT".equalsIgnoreCase(operationType)) {
            wallet.setBalance(wallet.getBalance() + amount);
        } else if ("WITHDRAW".equalsIgnoreCase(operationType)) {
            if (wallet.getBalance() < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            wallet.setBalance(wallet.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Invalid operation type");
        }
        return walletRepository.save(wallet);
    }

    public Wallet getWallet(UUID walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
    }
}
