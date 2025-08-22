package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    void testReadDataSize() {
        StudentHardCodeDatasource dtc = new StudentHardCodeDatasource();
        StudentList l = dtc.readData();
        assertEquals(l.getStudents().size(), 4);
    }
}