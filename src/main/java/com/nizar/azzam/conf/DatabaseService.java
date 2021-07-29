package com.nizar.azzam.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseService {
    private String username;
    private String password;
    private String driverClassname;
}
