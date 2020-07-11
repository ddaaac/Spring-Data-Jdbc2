package spring.data.jdbc.example.id;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Table("ORDERS")
public class Order {
    @Id
    private UUID id;

    private String title;

    public static class BeforeSaveOrderCallback implements BeforeSaveCallback<Order> {
        @Override
        public Order onBeforeSave(Order aggregate, MutableAggregateChange<Order> aggregateChange) {
            aggregate.id = UUID.randomUUID();
            return aggregate;
        }
    }
}
