package utils;

import dto.User;
import net.datafaker.Faker;

public class UserFactory {

    private static final Faker faker = new Faker();

    public static User positiveUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password("Zxcvbnm!29")
                .build();
    }
}


