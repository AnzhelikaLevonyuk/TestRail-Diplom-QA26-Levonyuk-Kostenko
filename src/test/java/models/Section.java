package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Section {
    String name;
    @EqualsAndHashCode.Exclude
    String description;
}
