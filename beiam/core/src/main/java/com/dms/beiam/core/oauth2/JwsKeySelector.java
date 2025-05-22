package com.dms.beiam.core.oauth2;

import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.proc.JWSAlgorithmFamilyJWSKeySelector;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.JWTClaimsSetAwareJWSKeySelector;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Configuration
public class JwsKeySelector implements JWTClaimsSetAwareJWSKeySelector<SecurityContext> {
    private final Map<String, JWSKeySelector<SecurityContext>> selectors = new ConcurrentHashMap<>();
    private final String uri = "http://localhost:8080/oauth2/jwks";

    @Override
    public List<? extends Key> selectKeys(JWSHeader jwsHeader, JWTClaimsSet jwtClaimsSet, SecurityContext securityContext)
            throws KeySourceException {
        return this.selectors.computeIfAbsent(toTenant(jwtClaimsSet), this::fromTenant)
                .selectJWSKeys(jwsHeader, securityContext);
    }

    private String toTenant(JWTClaimsSet claimSet) {
        return (String) claimSet.getClaim("iss");
    }

    private JWSKeySelector<SecurityContext> fromTenant(String tenant) {
        return Optional.of(uri)
                .map(this::fromUri)
                .orElseThrow(() -> new IllegalArgumentException("unknown tenant"));
    }

    private JWSKeySelector<SecurityContext> fromUri(String uri) {
        try {
            return JWSAlgorithmFamilyJWSKeySelector.fromJWKSetURL(new URL(uri));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
