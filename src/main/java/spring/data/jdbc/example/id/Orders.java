package spring.data.jdbc.example.id;

import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.AbstractRelationalEventListener;
import org.springframework.data.relational.core.mapping.event.AfterSaveEvent;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
public class Orders {
    @Id
    private UUID id;

    private String title;

    @Order(1)
    public static class BeforeSaveOrderCallback implements BeforeSaveCallback<Orders> {
        @Override
        public Orders onBeforeSave(Orders aggregate, MutableAggregateChange<Orders> aggregateChange) {
            aggregate.id = UUID.randomUUID();
            return aggregate;
        }
    }
}
