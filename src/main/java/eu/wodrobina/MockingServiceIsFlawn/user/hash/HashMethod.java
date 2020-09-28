package eu.wodrobina.MockingServiceIsFlawn.user.hash;

import eu.wodrobina.MockingServiceIsFlawn.user.hash.producers.BCryptProducer;
import eu.wodrobina.MockingServiceIsFlawn.user.hash.producers.HashProducer;

import java.util.Map;

public enum HashMethod {
    BCRYPT;

    private static final Map<HashMethod, HashProducer> hashMethodsToFactories = availableCryptingMethods();

    public static String hash(HashMethod hashMethod, String value) {
        return hashMethodsToFactories.get(hashMethod)
                .hash(value);
    }

    private static Map<HashMethod, HashProducer> availableCryptingMethods() {
        return Map.ofEntries(Map.entry(HashMethod.BCRYPT, new BCryptProducer()));
    }
}
