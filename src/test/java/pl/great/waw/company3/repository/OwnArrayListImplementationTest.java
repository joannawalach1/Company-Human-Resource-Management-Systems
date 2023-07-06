package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.Students;

import static org.junit.jupiter.api.Assertions.*;

class myArrayImplementationTest {
    private final MyArrayImplementation students = new MyArrayImplementation();

    @Test
    void getStudents() {
        MyArrayImplementation array = new MyArrayImplementation();

        Students student1 = new Students(1, "Anna", 32);
        array.addStudents(student1);
        array.getStudents(0);

        assertEquals(1, array.getSize(), "Size should be 1");
        assertEquals(student1.getId(), array.getSize(), "Element 1 should be added");

        Object student2 = new Students(2, "Gucio", 20);
        Object student3 = new Students(3, "Teodor", 32);
        array.addStudents(student2);
        array.addStudents(student3);
        array.getStudents(1);
        array.getStudents(2);

        assertEquals(3, array.getSize(), "Size should be 3");
        assertEquals(student2, array.getStudents(1), "Element 2 should be added at index 1");
        assertEquals(student3, array.getStudents(2), "Element 3 should be added at index 2");
    }

    @Test
    void addStudents() {
        MyArrayImplementation array = new MyArrayImplementation();

        Students student1 = new Students(1, "Anna", 32);
        array.addStudents(student1);

        assertEquals(1, array.getSize());
        assertEquals(student1, array.getStudents(0));

        Object student2 = new Students(2, "Gucio", 20);
        Object student3 = new Students(3, "Teodor", 32);
        array.addStudents(student2);
        array.addStudents(student3);

        assertEquals(3, array.getSize(), "Size should be 3");
        assertEquals(student2, array.getStudents(1));
        assertEquals(student3, array.getStudents(2));
    }

    @Test
    void removeStudentsById() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = new Students(1, "Anna", 32);
        Object student2 = new Students(2, "Darek", 11);
        array.addStudents(student1);
        array.addStudents(student2);
        array.removeStudentsById(0);

        assertTrue(array.getStudents(1) == null);

        Object student3 = new Students(3, "Gucio", 20);
        Object student4 = new Students(4, "Teodor", 32);
        array.addStudents(student3);
        array.addStudents(student4);
        array.removeStudentsById(1);

        assertEquals(2, array.getSize(), "Size should be 2");
    }

    @Test
    void updateStudents() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object[] student1 = array.addStudents(new Students(1, "Zofia", 23));
        Object updatedStudent = array.updateStudent(new Students(1, "Emilia", 33));

        assertEquals(array.getStudents(0), updatedStudent);
    }

    @Test
    void removeAll() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = array.addStudents(new Students(1, "Zofia", 23));
        Object student2 = array.addStudents(new Students(2, "Dominika", 13));
        Object student3 = array.addStudents(new Students(3, "Magda", 1));
        array.removeAll();

        assertTrue(array.getSize() == 0);
    }

    @Test
    void containsStudents() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = array.addStudents(new Students(1, "Zofia", 23));
        Object student2 = array.addStudents(new Students(2, "Dominika", 13));
        Object student3 = array.addStudents(new Students(3, "Magda", 1));
        boolean stud = array.containsStudents(student1);
        assertTrue(stud);
    }

    @Test
    void isEmpty() {
        MyArrayImplementation array = new MyArrayImplementation();
        int isEmpty = array.isEmpty();

        assertEquals(0, isEmpty);
    }

    @Test
    void setStudents() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = array.addStudents(new Students(1, "Zofia", 23));
        Object student2 = array.addStudents(new Students(2, "Dominika", 13));
        Object student3 = array.addStudents(new Students(3, "Magda", 1));
        Object newStudent = array.setStudents(new Students(1, "Zofia", 23), 4);

        assertEquals(newStudent, array.getStudents(3));
    }

    @Test
    void toArray() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = array.addStudents(new Students(1, "Emilia", 23));
        Object student2 = array.addStudents(new Students(2, "Dominika", 13));
        Object student3 = array.addStudents(new Students(3, "Magda", 1));
        Object[] newStudents = array.toArray();
        assertNotNull(newStudents);
        assertEquals(2, newStudents.length - 1);
        assertEquals("Emilia", ((Students) newStudents[0]).getName());
    }

    @Test
    void printStudents() {
        MyArrayImplementation array = new MyArrayImplementation();
        Object student1 = array.addStudents(new Students(1, "Zofia", 23));
        Object student2 = array.addStudents(new Students(2, "Dominika", 13));
        Object student3 = array.addStudents(new Students(3, "Magda", 1));
        Object[] studentsArray = array.toArray();

        System.out.println("Array size: " + array.getSize());
        System.out.println("Array contents:");
        for (int i = 0; i < studentsArray.length; i++) {
            Students student = (Students) studentsArray[i];
            System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
        }

    }
}