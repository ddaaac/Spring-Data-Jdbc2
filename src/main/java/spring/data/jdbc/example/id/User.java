package spring.data.jdbc.example.id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.event.AbstractRelationalEventListener;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User implements Persistable<Long> {
    @Id
    private final Long id;

    private final String name;

    @Transient
    private boolean isNew = false;

    public static User of(Long id, String name) {
        return new User(id, name);
    }

    public static User newUser(Long id, String name) {
        User user = new User(id, name);
        user.isNew = true;
        return user;
    }

    @CreatedDate
    @Override
    public boolean isNew() {
        return isNew;
    }

    public static class BeforeSaveUser extends AbstractRelationalEventListener<User> {
        @Override
        protected void onBeforeSave(BeforeSaveEvent<User> event) {
            // Some other business event could be here
            System.out.println(event.getEntity().getName() + " is now saved...");
        }
    }
}
