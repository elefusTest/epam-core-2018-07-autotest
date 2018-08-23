package com.epam.se02.lombok;// import com.epam.se02.lombok.PersonImpl

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PersonImplTest {
    @Test
    @SneakyThrows
    @DisplayName("All methods works correctly")
    void testAllMethods() {
//        PersonImpl personImpl = new PersonImpl(36, "Вячеслав", "Лапин");
//        System.out.println(personImpl.age()); // 36
//        System.out.println(personImpl.firstName()); // "Вячеслав"
//        System.out.println(personImpl.lastName()); // "Лапин"
//
//        PersonImpl personImpl2 = new PersonImpl(5, "Владимир", "Лапин");
//        System.out.println(personImpl2);

        PersonImpl person = PersonImpl.builder()
//                .age(36)
                .firstName("Вячеслав")
                .lastName("Лапин")
//                .contacts(Arrays.asList("sf", "sf654", "sfsef"))
                .contact("khjgsdgf")
                .contact("kusgf")
                .contact("kushadfharth")
                .build();

        assertThat(person.getAge()).isEqualTo(36);

        StringBuffer stringBuffer = new StringBuffer("dfg")
                .append("asargadrg")
                .append("argadrgaertgaer")
                .append("jyfgwejfhgewfка");

        int x = 55;
        int y;
        y = x + 8;

        PersonImpl person1 = new PersonImpl()
                .setAge(45)
                .setFirstName("Aghfb")
                .setLastName("argfaergref");

        assertThat(person1.getLastName()).isEqualTo("argfaergref");

        PersonImpl person2 = person1.withLastName("Петичкин");
    }

}