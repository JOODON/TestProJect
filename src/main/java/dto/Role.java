package dto;

public class Role {
    private int rold_id;
    private String description;

    public int getRold_id() {
        return rold_id;
    }

    public void setRold_id(int rold_id) {
        this.rold_id = rold_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rold_id=" + rold_id +
                ", description='" + description + '\'' +
                '}';
    }
}
