package com.bucur.randomizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoIustinTest {

    @Test
    public void givenListOfNames_whenUpdateFirstName_thenReturnNewListWithUpdate() {
        // 2 given
        DemoIustin demoIustin = new DemoIustin();
        List<String> names = new ArrayList<>();
        names.add("dan");
        names.add("bob");
        String oldName = "dan";
        String newName = "daniela";

        List<String> expected = Arrays.asList("daniela", "bob");

        // 1 when
        List<String> actual = demoIustin.updatePerson(names, oldName, newName);

        // 3 then
        assertThat(expected).isEqualTo(actual);
    }
}