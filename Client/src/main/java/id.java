public class id {

    private String userId;
    private String name;
    private String github;


    public id(String userId, String name, String github) {
        this.userId = userId;
        this.name = name;
        this.github = github;
    }

    public id(String name, String github) {
        this.name = name;
        this.github = github;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }


    public String toString1() {
        return "id {" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
