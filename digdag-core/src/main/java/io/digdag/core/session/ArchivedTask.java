package io.digdag.core.session;

import java.util.List;
import java.time.Instant;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import io.digdag.spi.TaskReport;
import io.digdag.client.config.Config;
import static com.google.common.base.Preconditions.checkState;

@Value.Immutable
@JsonSerialize(as = ImmutableArchivedTask.class)
@JsonDeserialize(as = ImmutableArchivedTask.class)
public abstract class ArchivedTask
        extends StoredTask
{
    public abstract Config getSubtaskConfig();

    public abstract Config getExportParams();

    public abstract Config getStoreParams();

    public abstract Optional<TaskReport> getReport();

    public abstract Config getError();

    @Value.Check
    protected void check()
    {
        //checkState(!getError().isPresent() || !getError().get().isEmpty(), "error must not be empty if not null");
    }
}
