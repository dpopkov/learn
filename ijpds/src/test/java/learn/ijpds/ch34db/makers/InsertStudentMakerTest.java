package learn.ijpds.ch34db.makers;

import learn.ijpds.ch34db.model.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class InsertStudentMakerTest {

    @Test
    public void testParse() {
        String line = "444111110 Jacob R Smith 9129219434 1985-04-09 99 Kingston Street 31435 BIOL";
        InsertStudentMaker maker = new InsertStudentMaker();
        Student result = maker.parse(line);
        Student expected = new Student("444111110", "Jacob", "R", "Smith", "9129219434",
                "1985-04-09", "99 Kingston Street", "31435", "BIOL");
        assertThat(result, is(expected));
    }

    @Test
    public void testParseWithNull() {
        String line = "444111110 Jacob R Smith 9129219434 null 99 Kingston Street 31435 BIOL";
        InsertStudentMaker maker = new InsertStudentMaker();
        Student result = maker.parse(line);
        Student expected = new Student("444111110", "Jacob", "R", "Smith", "9129219434",
                null, "99 Kingston Street", "31435", "BIOL");
        assertThat(result, is(expected));
    }

    @Test
    public void testToInsert() {
        Student student = new Student("444111110", "Jacob", "R", "Smith", "9129219434",
                "1985-04-09", "99 Kingston Street", "31435", "BIOL");
        List<String> columns = Arrays.asList("ssn", "firstName", "mi", "lastName", "phone", "birthDate", "street", "zipCode", "deptID");
        String expected = "insert into Student "
                + "(ssn, firstName, mi, lastName, phone, birthDate, street, zipCode, deptID) values "
                + "('444111110', 'Jacob', 'R', 'Smith', '9129219434', '1985-04-09', '99 Kingston Street', '31435', 'BIOL');";
        String sql = new InsertStudentMaker().toInsert(student, columns);
        assertThat(sql, is(expected));
    }
}
