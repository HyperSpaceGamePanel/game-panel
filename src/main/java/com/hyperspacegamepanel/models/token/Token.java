package com.hyperspacegamepanel.models.token;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hyperspacegamepanel.models.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tokens")
@Data
@NoArgsConstructor
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tokenValue;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "issued_at", nullable = false)
    private Instant issuedAt = Instant.now();

    public static final long TOKEN_EXPIRATON_TIME = 30 * 60 * 1000;
    private Instant expirationTime = Instant.now().plusMillis(TOKEN_EXPIRATON_TIME);

    private boolean isExpired = false;

    public boolean isExpired() {
        return isExpired || Instant.now().isAfter(expirationTime);
    }

    public void expire() {
        setExpired(true);
    }

    public Token(String tokenValue, User user) {
        this.tokenValue = tokenValue;
        this.user = user;
    }

}
