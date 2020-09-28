package eu.wodrobina.MockingServiceIsFlawn.user.domain;

import eu.wodrobina.MockingServiceIsFlawn.user.hash.HashMethod;

import javax.persistence.Embeddable;
import java.time.Instant;

@Embeddable
public class Password {

    private String cryptedPassword;
    private HashMethod hashMethod;
    private Instant created;
    private Instant validTo;

    public Password(HashMethod hashMethod, String value) {
        this.hashMethod = hashMethod;
        this.cryptedPassword = HashMethod.hash(hashMethod, value);
    }

    public Password(HashMethod hashMethod, String value, Instant validTo) {
        this(hashMethod, value);
        this.validTo = validTo;
    }

    public String getCryptedPassword() {
        return cryptedPassword;
    }

    public void setNewPassword(HashMethod hashMethod, String value) {
        this.hashMethod = hashMethod;
        this.cryptedPassword = HashMethod.hash(hashMethod, value);
    }

    public boolean isExpirationTimeSet() {
        return validTo != null;
    }

    public boolean hasExpired() {
        return isExpirationTimeSet() && Instant.now().isAfter(validTo);
    }
}
