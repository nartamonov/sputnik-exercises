package ru.sputnik.exercises;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static ru.sputnik.exercises.Exercises.*;

public class ExercisesTest {
    @Test
    public void testFindAllTelNumbers() {
        String sampleText = "Несколько телефонных номеров для примера:" +
                "+7 (926) 819-00-33, +7 (940) 766-22-18, +7 (5O4) 220-00-70, +8 (303) 000-20--30";
        List<String> telNumbers = findAllTelNumbers(sampleText);

        assertThat(telNumbers.size(), equalTo(2));
        assertThat(telNumbers, hasItems("+7 (926) 819-00-33", "+7 (940) 766-22-18"));
    }

    @Test
    public void testIsImageResource() throws MalformedURLException {
        assertThat(isJPEGResource(new URL("http://animalia-life.com/data_images/cat/cat7.jpg")), is(true));
        assertThat(isJPEGResource(new URL("http://animalia-life.com/data_images/cat/mycat.jpg")), is(false));
        assertThat(isJPEGResource(new URL("http://icons.iconarchive.com/icons/fixicon/farm/256/cat-icon.png")), is(false));
    }
}
