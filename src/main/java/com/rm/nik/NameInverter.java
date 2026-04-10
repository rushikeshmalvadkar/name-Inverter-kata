package com.rm.nik;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NameInverter {

    public String invert(String name) {
        if (Objects.isNull(name)) throw new NullPointerException();
        String[] splitName = name.trim().split(" ");
        if (splitName.length > 1) {
            List<String> withoutSpaceNames = removeSpaceFrom(splitName);
            String firstName = withoutSpaceNames.get(0);
            String lastName = withoutSpaceNames.get(1);
            return String.format("%s,%s", firstName, lastName);
        }
        return name.trim();
    }

    private List<String> removeSpaceFrom(String[] splitName) {
        return Arrays.stream(splitName)
                .filter(value -> !value.isEmpty())
                .toList();
    }
}
