package learn.ijpds.ch34db.hfsql;

import learn.ijpds.ch34db.JdbcUtil;

import java.io.IOException;
import java.sql.*;

public class MyContacts2Interest {
    public void fill() throws IOException, SQLException {
        try (Connection connection = JdbcUtil.connectToDb(Database.NAME)) {
            PreparedStatement find = connection.prepareStatement(
                    "select int_id from interest where interest = ?"
            );
            PreparedStatement insert = connection.prepareStatement(
                    "insert into my_contacts2_interest (contact_id, int_id) values (?, ?)");
            String[] columns = {"interest1", "interest2", "interest3"};
            Statement select = connection.createStatement();
            String frmSelect = "select contact_id, %s from my_contacts2";
            for (String column : columns) {
                ResultSet rs = select.executeQuery(String.format(frmSelect, column));
                while (rs.next()) {
                    int contact_id = rs.getInt(1);
                    String interest = rs.getString(2);
                    if (interest != null) {
                        interest = interest.trim();
                        if (!interest.isEmpty()) {
                            find.setString(1, interest);
                            ResultSet found = find.executeQuery();
                            if (found.next()) {
                                int int_id = found.getInt(1);
                                insert.setInt(1, contact_id);
                                insert.setInt(2, int_id);
                                insert.executeUpdate();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyContacts2Interest().fill();
    }
}
