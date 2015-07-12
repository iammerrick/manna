package manna.plans;

import manna.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "plans")
    private List<User> users;

    @OneToMany
    @JoinTable(name="plans_texts")
    private List<Text> texts;

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
