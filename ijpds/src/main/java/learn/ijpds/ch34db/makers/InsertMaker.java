package learn.ijpds.ch34db.makers;

import java.util.List;

public class InsertMaker {
    private final String table;

    public InsertMaker(String table) {
        this.table = table;
    }

    protected StringBuilder prependInsertColumns(List<String> columns) {
        StringBuilder builder = new StringBuilder();
        builder.append("insert into ");
        builder.append(table);
        builder.append(" (");
        for (int i = 0; i < columns.size(); i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(columns.get(i));
        }
        builder.append(") values (");
        return builder;
    }

    protected String wrap(String s) {
        return s == null ? "null" : "'" + s + "'";
    }
}
