package pl.great.waw.company3.domain;

public class Students {
    private Number id;
    private String name;
    private Number age;

    public Students(Number id, String name, Number age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Students() {
        super();
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
    }
}
