package com.epam.se02.lombok;// import com.epam.se02.lombok.Person

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PersonTest {
    @Test
    @SneakyThrows
    @DisplayName("All methods works correctly")
    void testAllMethods() {
        Person person = new Person(36, "Вячеслав", "Лапин");
        System.out.println(person.getAge()); // 36
        System.out.println(person.getFirstName()); // "Вячеслав"
        System.out.println(person.getLastName()); // "Лапин"

        Person person2 = new Person(5, "Владимир", "Лапин");
        System.out.println(person2);
    }

}