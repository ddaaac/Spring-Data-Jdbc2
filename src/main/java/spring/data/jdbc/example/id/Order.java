package spring.data.jdbc.example.id;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

@Table("ORDERS")
public class Order {
    @Id
    private UUID id;
    private String title;

    public Order(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public static class BeforeSaveOrderCallback implements BeforeSaveCallback<Order> {
        @Override
        public Order onBeforeSave(Order aggregate, MutableAggregateChange<Order> aggregateChange) {
            aggregate.id = UUID.randomUUID();
            return aggregate;
        }
    }
}
