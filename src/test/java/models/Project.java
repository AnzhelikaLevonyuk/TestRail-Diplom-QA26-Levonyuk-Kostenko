package models;

import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Builder(setterPrefix = "set")
@Data
public class Project {
    private String name;
    private String announcement;

    @EqualsAndHashCode.Exclude
    private boolean showAnnouncement;
    @EqualsAndHashCode.Exclude
    private ProjectType projectType;
    @EqualsAndHashCode.Exclude
    private boolean enableTestCaseApprovals;
    @EqualsAndHashCode.Exclude
    private String references;
}
