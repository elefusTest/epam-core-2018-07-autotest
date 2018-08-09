package com.epam.se02.lombok;

import lombok.*;
import lombok.Builder.Default;
import lombok.experimental.Wither;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Data // @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
//@Value // {final перед классом} @Getter @ToString @EqualsAndHashCode @AllArgsConstructor @FieldDefaults(level = PRIVATE, makeFinal = true)
@EqualsAndHashCode(exclude = "age")
@Builder // @AllArgsConstructor(PACKAGE)
@Slf4j
public class PersonImpl implements Person {

    @Default
    int age = 36;
    String firstName;

    @Wither
    @Getter(onMethod = @__(@Override))
    String lastName;

    @Singular
    List<String> contacts;

    @SneakyThrows
    public final String method() {


//        try {
            throw new SQLException("jkhsadg");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void main(String... __) {
        new PersonImpl().method();
    }
}
