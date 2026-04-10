package com.rm.nik;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameInverterTest {
    @Test
    void invert_null_should_throw_null_pointer_exception() {
        NameInverter nameInverter = new NameInverter();
        assertThatThrownBy(() -> nameInverter.invert(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void invert_empty_should_return_empty_string() {
        NameInverter nameInverter = new NameInverter();
        assertThat(nameInverter.invert("")).isEqualTo("");
    }

    @Test
    void invert_firstName_should_return_firstName() {
        NameInverter nameInverter = new NameInverter();
        assertThat(nameInverter.invert("Johan")).isEqualTo("Johan");
        assertThat(nameInverter.invert("  Johan  ")).isEqualTo("Johan");
    }

    @Test
    void invert_firstName_and_lastName_should_return_firstName_comma_lastName() {
        NameInverter nameInverter = new NameInverter();
        assertThat(nameInverter.invert("Johan Smith")).isEqualTo("Johan,Smith");
        assertThat(nameInverter.invert("   Johan   Smith")).isEqualTo("Johan,Smith");
    }
}
