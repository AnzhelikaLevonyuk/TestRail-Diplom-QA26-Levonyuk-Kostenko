package models;

import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "set")
@Data
public class Section {
    String name;
    String description;
}
