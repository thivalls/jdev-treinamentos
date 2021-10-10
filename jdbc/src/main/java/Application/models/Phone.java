package Application.models;

public class Phone {
    private Long id;
    private Long user_id;
    private String type;
    private String number;

    public Phone(Long user_id, String type, String number) {
        this.user_id = user_id;
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
