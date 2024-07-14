package models;

import enums.ProjectType;

import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private ProjectType projectType;
    private boolean enableTestCaseApprovals;

    private Project(ProjectBuilder projectBuilder) {
        this.name = projectBuilder.name;
        this.announcement = projectBuilder.announcement;
        this.showAnnouncement = projectBuilder.showAnnouncement;
        this.projectType = projectBuilder.projectType;
        this.enableTestCaseApprovals = projectBuilder.enableTestCaseApprovals;
    }

    public Project() {

    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }


    public ProjectType getProjectType() {
        return projectType;
    }


    public boolean isEnableTestCaseApprovals() {
        return enableTestCaseApprovals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name)
                && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, showAnnouncement, projectType, enableTestCaseApprovals);
    }

    @Override
    public String toString() {
        return "ProjectBuilder{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", showAnnouncement=" + showAnnouncement +
                ", enableTestCaseApprovals=" + enableTestCaseApprovals +
                ", projectType=" + projectType +
                '}';
    }

    public static class ProjectBuilder {
        private final String name;
        private String announcement;
        private boolean showAnnouncement;
        private boolean enableTestCaseApprovals;
        private ProjectType projectType;


        public ProjectBuilder(String name) {
            this.name = name;
        }

        public ProjectBuilder setShowAnnouncement(boolean showAnnouncement) {
            this.showAnnouncement = showAnnouncement;
            return this;
        }

        public ProjectBuilder setAnnouncement(String announcement) {
            this.announcement = announcement;
            return this;
        }

        public ProjectBuilder setProjectType(ProjectType projectType) {
            this.projectType = projectType;
            return this;
        }

        public ProjectBuilder setEnableTestCaseApprovals(boolean enableTestCaseApprovals) {
            this.enableTestCaseApprovals = enableTestCaseApprovals;
            return this;
        }

        public Project build() {
            return new Project(this);
        }

    }
}
