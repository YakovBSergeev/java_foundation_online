package ru.itsjava.oppPractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itsjava.oopPractice.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SuppressWarnings("ALL")
@DisplayName("Класс Person должен:")
public class PersonTest {

    public static final String DEFAULT_NAME = "Gustav";
    public static final int DEFAULT_AGE = 41;
    public static final int NEW_AGE = DEFAULT_AGE + 1;


    @DisplayName(" корректно создаваться конструктором")
    @Test
    public void shouldHaveCorrectConstructor() {
        Person personPos = new Person( DEFAULT_NAME, DEFAULT_AGE );

        assertEquals( DEFAULT_NAME, personPos.getName() );
        assertEquals( DEFAULT_AGE, personPos.getAge() );
        assertFalse( personPos.equals( DEFAULT_NAME ) );
    }

    @Test
    public void testCorrectTakeBeer() {

        boolean test = true;
        Person person = new Person( DEFAULT_NAME, DEFAULT_AGE );
        boolean val = person.takeBeer( DEFAULT_AGE );
        assertEquals( val, test );


    }

    @Test
    public void testCorrectBirthday() {

        Person person = new Person( DEFAULT_NAME, DEFAULT_AGE );
        person.birthday();
        assertEquals( NEW_AGE, person.getAge() );


    }


    @DisplayName(" корректно изменять возраст")
    @Test
    public void shouldHaveCorrectUpdateAge() {
        Person personPos = new Person( DEFAULT_NAME, DEFAULT_AGE );
        personPos.setAge( NEW_AGE );

        assertEquals( NEW_AGE, personPos.getAge() );
    }
}

