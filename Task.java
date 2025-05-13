package java;

public class Task {

    private String Name;
    private String status;
    private boolean important;

    public void setname(String name) {
        this.Name = name;
    }

    public String getname() {
        return Name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public Boolean getimportant() {
        return important;
    }

    public Task(String Name, String Status, boolean important) {
        this.Name = Name;
        this.status = Status;
        this.important = important;

    }

    public String getName() {
        return Name;
    }

    public void display() {
        System.out.println("Name of the task" + Name);
        System.out.println("Status" + status);
        System.out.println("important " + important);
    }
}
