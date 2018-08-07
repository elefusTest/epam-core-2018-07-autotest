package com.epam.se02.lombok;

import lombok.Value;

//@Data // @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor(access = PRIVATE)
@Value // {final перед классом} @Getter @ToString @EqualsAndHashCode @AllArgsConstructor @FieldDefaults(level = PRIVATE, makeFinal = true)
public class Person {
    int age;
    String firstName;
    String lastName;
}
