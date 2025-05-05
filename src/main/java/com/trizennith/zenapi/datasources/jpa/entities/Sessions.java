package com.trizennith.zenapi.datasources.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name = "user_sessions")
@Entity
public class Sessions {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    private User user;

    @Getter
    @Setter
    @Column(name = "session_token", nullable = false, unique = true)
    private String sessionToken;

    @Getter
    @Setter
    @Column(name = "client_ip", nullable = true)
    private String clientIp;

    @Getter
    @Setter
    @Column(name = "user_agent", nullable = true)
    private String userAgent;

    @Getter
    @Setter
    @Column(name = "issued_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuedAt;

    @Getter
    @Setter
    @Column(name = "expires_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresAt;

    @Getter
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @Getter
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}