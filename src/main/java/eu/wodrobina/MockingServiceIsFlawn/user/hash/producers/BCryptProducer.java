package eu.wodrobina.MockingServiceIsFlawn.user.hash.producers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;

public class BCryptProducer implements HashProducer {

    public static final int DEFAULT_COST = 1;

    @Override
    public String hash(String value) {
        return BCrypt.with(LongPasswordStrategies.none())
                .hashToString(DEFAULT_COST, value.toCharArray());
    }
}
