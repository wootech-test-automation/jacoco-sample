package pairmatching.domain;

public enum Course {

    BACKEND("백엔드", "/backend-crew.md"),
    FRONTEND("프론트엔드", "/frontend-crew.md");

    private static final String FILE_PATH_PREFIX = "src/main/resources";
    private String name;
    private String path;

    Course(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return FILE_PATH_PREFIX + path;
    }
}
