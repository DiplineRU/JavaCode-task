package JavaCode.task.JavaCode;

import jakarta.persistence.*;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    private UUID id;

    @Column(nullable = false)
    private long balance;

    public Wallet() {
    }

    public Wallet(UUID id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
