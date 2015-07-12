package manna.users;

import manna.plans.Plan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String number;

    @ManyToMany
    @JoinTable(name="plans_users")
    private List<Plan> plans;

    protected User() {}

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return String.format("User[id=%d, name=%s, number=%s]", id, name, number);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
