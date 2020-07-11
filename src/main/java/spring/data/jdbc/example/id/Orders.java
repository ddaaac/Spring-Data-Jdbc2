package spring.data.jdbc.example.id;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Orders {
    @Id
    private UUID id;

    private String title;

    public static class BeforeSaveOrderCallback implements BeforeSaveCallback<Orders> {
        @Override
        public Orders onBeforeSave(Orders aggregate, MutableAggregateChange<Orders> aggregateChange) {
            aggregate.id = UUID.randomUUID();
            return aggregate;
        }
    }
}
