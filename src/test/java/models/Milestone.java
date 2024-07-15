package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Milestone {
    private String name;
    @EqualsAndHashCode.Exclude
    private String references;
    private String description;
    private String startDate;
    @EqualsAndHashCode.Exclude
    private String endDate;
    @EqualsAndHashCode.Exclude
    private boolean milestoneIsCompleted;
}
