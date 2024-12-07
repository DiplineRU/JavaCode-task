package JavaCode.task.JavaCode.Service.ServiceInterface;

import JavaCode.task.JavaCode.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

}