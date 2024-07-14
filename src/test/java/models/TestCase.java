package models;

import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;

import java.util.Objects;

public class TestCase {
    private String title;
    private TestCaseType type;
    private TestCasePriority priority;
    private TestCaseStatus status;
    private String assignedTo;
    private String preconditions;
    private String steps;
    private String expectedResult;


    public TestCase(TestCaseBuilder testCaseBuilder) {
        this.title = testCaseBuilder.title;
        this.type = testCaseBuilder.type;
        this.priority = testCaseBuilder.priority;
        this.status = testCaseBuilder.status;
        this.assignedTo = testCaseBuilder.assignedTo;
        this.preconditions = testCaseBuilder.preconditions;
        this.steps = testCaseBuilder.steps;
        this.expectedResult = testCaseBuilder.expectedResult;
    }

    public TestCase() {
    }

    public String getTitle() {
        return title;
    }

    public TestCaseType getType() {
        return type;
    }

    public TestCasePriority getPriority() {
        return priority;
    }

    public TestCaseStatus getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public String getSteps() {
        return steps;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(title, testCase.title) && type == testCase.type && priority == testCase.priority && status == testCase.status && Objects.equals(assignedTo, testCase.assignedTo) && Objects.equals(preconditions, testCase.preconditions) && Objects.equals(steps, testCase.steps) && Objects.equals(expectedResult, testCase.expectedResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, priority, status, assignedTo, preconditions, steps, expectedResult);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", preconditions='" + preconditions + '\'' +
                ", steps='" + steps + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }

    public static class TestCaseBuilder {
        private final String title;
        private TestCaseType type;
        private TestCasePriority priority;
        private TestCaseStatus status;
        private String assignedTo;
        private String preconditions;
        private String steps;
        private String expectedResult;


        public TestCaseBuilder(String title) {
            this.title = title;
        }


        public TestCaseBuilder setType(TestCaseType type) {
            this.type = type;
            return this;
        }

        public TestCaseBuilder setPriority(TestCasePriority priority) {
            this.priority = priority;
            return this;
        }

        public TestCaseBuilder setStatus(TestCaseStatus status) {
            this.status = status;
            return this;
        }

        public TestCaseBuilder setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
            return this;
        }

        public TestCaseBuilder setPreconditions(String preconditions) {
            this.preconditions = preconditions;
            return this;
        }

        public TestCaseBuilder setSteps(String steps) {
            this.steps = steps;
            return this;
        }

        public TestCaseBuilder setExpectedResult(String expectedResult) {
            this.expectedResult = expectedResult;
            return this;
        }

        public TestCase build() {
            return new TestCase(this);
        }

    }
}
