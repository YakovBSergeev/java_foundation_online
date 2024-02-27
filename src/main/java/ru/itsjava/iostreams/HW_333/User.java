package ru.itsjava.iostreams.HW_333;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data

public class User implements Serializable {
    private Object login;
    private transient Object password;

}
