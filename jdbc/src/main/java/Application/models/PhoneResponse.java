package Application.models;

public class PhoneResponse {
    private String name;
    private String number;
    private String type;

    public PhoneResponse(String name, String number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PhoneResponse{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
