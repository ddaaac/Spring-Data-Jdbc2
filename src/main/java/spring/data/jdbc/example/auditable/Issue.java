package spring.data.jdbc.example.auditable;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import spring.data.jdbc.example.id.Member;

@Builder
@Getter
public class Issue {
    @Id
    @With(AccessLevel.PACKAGE)
    private final Long id;

    @CreatedBy
    private final AggregateReference<Member, Long> memberId;

    @NotBlank
    private final String title;

    @CreatedDate
    @With(AccessLevel.PACKAGE)
    private final LocalDateTime createdAt;

    @LastModifiedDate
    @With(AccessLevel.PACKAGE)
    private final LocalDateTime updatedAt;
}
