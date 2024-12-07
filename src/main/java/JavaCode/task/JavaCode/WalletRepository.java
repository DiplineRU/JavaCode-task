package JavaCode.task.JavaCode;

import JavaCode.task.JavaCode.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

}