package org.example.limits.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table("common_limits")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CommonLimit
        //  implements Persistable
{
    @Id
    Long id;

    @NonNull
    String clientType;
    @Builder.Default
    @NonNull
    LocalDateTime dateBegin = LocalDateTime.now();
    LocalDateTime dateEnd;
    @NonNull
    float Amount;
/*
    @Override
    public boolean isNew() {
        return true;
    }*/

    @MappedCollection(idColumn = "common_limit_ref"
               , keyColumn = "common_limit_order"
    )
    @Builder.Default
    List<ClientLimit> clientLimit = new ArrayList<>();
}
