package com.dms.beiam.persistence.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "realms")
@Getter
@NoArgsConstructor
public class Realm {

    @Builder
    public Realm(String realmName, String realmAdminEmail) {
        this.realmName = realmName;
        this.realmAdminEmail = realmAdminEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "realm_name", nullable = false, unique = true)
    private String realmName;

    @Column(name = "realm_admin_email", nullable = false)
    private String realmAdminEmail;
}
