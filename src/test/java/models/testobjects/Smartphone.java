package models.testobjects;

import lombok.Data;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import java.io.Serializable;

@Data
public class Smartphone implements Serializable {

    private Ram ram;
    private Company company;

    public Smartphone() {}

    public Smartphone(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }
}
