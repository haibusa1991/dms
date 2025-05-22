package com.dms.beiam.core.oauth2;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class BeiamClientRegistrationRepository implements ClientRegistrationRepository {
    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        return null;
    }
}
