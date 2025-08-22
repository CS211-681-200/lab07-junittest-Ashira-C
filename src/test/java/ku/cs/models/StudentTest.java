package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
    void init() {
        s = new Student("67xxxxxx", "test");
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต 49 และ 2 คะแนน")
    void testAddScore() {
        s.addScore(40);
        assertEquals(40, s.getScore());
        s.addScore(20);
        assertEquals(60, s.getScore());
    }

    @Test
    void testCalculateGrade() {
        s.addScore(30);
        assertEquals("F", s.grade());
    }

    @Test
    void testChangeName() {
        s.changeName("Peak");
        assertEquals("Peak", s.getName());
    }

    @Test
    void testIsId() {
        Student s = new Student("123", "Peak");
        assertTrue(s.isId("123"));
        assertFalse(s.isId("456"));
    }

    @Test
    void testIsNameContains() {
        Student s = new Student("456", "Mai");
        assertTrue(s.isNameContains("Ma"));
        assertTrue(s.isNameContains("i"));
        assertFalse(s.isNameContains("Pea"));
    }

}