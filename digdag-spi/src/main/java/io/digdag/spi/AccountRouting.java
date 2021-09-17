package io.digdag.spi;

public interface AccountRouting
{
    enum ModuleType
    {
        EXECUTOR("executor"),
        AGENT("agent"),
        SCHEDULER("scheduler");

        private final String module;

        ModuleType(String module)
        {
            this.module = module;
        }

        @Override
        public String toString()
        {
            return module;
        }
    }


    Boolean enabled();

    String getFilterSQL(String column);

    default String getFilterSQL()
    {
        return getFilterSQL("site_id");
    }
}
