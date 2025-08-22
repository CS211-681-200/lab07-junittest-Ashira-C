package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList sl;
    @BeforeEach
    void init() {
        sl = new StudentList();
    }
    @Test
    void testAddNewStudentWithoutScore() {
        sl.addNewStudent("123", "Peak");

        ArrayList<Student> students = sl.getStudents();
        assertEquals(1, students.size());
        assertEquals("123", students.get(0).getId());
        assertEquals("Peak", students.get(0).getName());
    }

    @Test
    void testAddNewStudentWithScore() {
        sl.addNewStudent("456", "Mai", 80.0);

        ArrayList<Student> students = sl.getStudents();
        assertEquals(1, students.size());
        assertEquals("456", students.get(0).getId());
        assertEquals("Mai", students.get(0).getName());
        assertEquals(80.0, students.get(0).getScore());
    }

    @Test
    void testFindStudentById() {
        sl.addNewStudent("123", "Peak");
        Student s = sl.findStudentById("123");
        assertNotNull(s);
        assertEquals("123", s.getId());
    }

    @Test
    void testFilterByName() {
        sl.addNewStudent("123", "Peak");
        sl.addNewStudent("456", "Mai");
        sl.addNewStudent("789", "Peanut");
        StudentList filtered = sl.filterByName("Pea");
        assertEquals(2, filtered.getStudents().size());
        assertTrue(filtered.getStudents().get(0).getName().contains("Pea"));
    }

    @Test
    void testGiveScoreToId() {
        sl.addNewStudent("123", "Peak");
        sl.giveScoreToId("123", 10);
        Student s = sl.findStudentById("123");
        assertEquals(10, s.getScore());
    }

    @Test
    void testViewGradeOfId() {
        sl.addNewStudent("123", "Peak", 80.0);
        String grade = sl.viewGradeOfId("123");
        assertEquals("A", grade);
    }
}