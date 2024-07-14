package utils;

import com.github.javafaker.Faker;
import enums.ProjectType;
import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import models.Milestone;
import models.Project;
import models.TestCase;

public class TestDataGeneration {
    static Faker faker = new Faker();

    public static Project generateProject() {
        return new Project.ProjectBuilder(faker.country().name() + faker.number().randomDigit())
                .setShowAnnouncement(true)
                .setAnnouncement(faker.address().cityName())
                .setProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .build();
    }

    public static Project generateProjectWithoutName() {
        return new Project.ProjectBuilder("")
                .setShowAnnouncement(true)
                .setAnnouncement(faker.address().cityName())
                .setProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .build();
    }

    public static TestCase generateTestCase() {
        return new TestCase.TestCaseBuilder(faker.animal().name() + faker.number().randomDigit())
                .setType(TestCaseType.COMPATIBILITY)
                .setPriority(TestCasePriority.CRITICAL)
                .setStatus(TestCaseStatus.DESIGN)
                .setPreconditions("Preconditions")
                .setSteps("Steps").setExpectedResult("Expected result")
                .build();
    }

    public static Milestone generateMilestone() {
        return Milestone.builder()
                .setName(faker.color().name() + faker.number().randomDigit())
                .setReferences("References")
                .setDescription("Description")
                .setStartDate("6/16/2024")
                .setEndDate("6/30/2024")
                .setMilestoneIsCompleted(true)
                .build();
    }
}
