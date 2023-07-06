package pl.great.waw.company3.repository;

import pl.great.waw.company3.domain.Students;

public class MyArrayImplementation {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayImplementation() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object[] addStudents(Object student) {
        ensureCapacity(size + 1);
        array[size] = student;
        size++;
        return array;
    }

    public Object getStudents(int index) {
        if (index >= 0 && index <= size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Object removeStudentsById(int id) {
        Object student = getStudents(id);
        if (student == null) {
            throw new IllegalArgumentException("Student doesn't exist" + student);
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(student)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Object removedStudent = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
            return removedStudent;
        }
        return null;

    }

    public Object updateStudent(Object updatedStudent) {
        int id = 0;
        Object student = getStudents(id);
        if (student == null) {
            throw new IllegalArgumentException("Student doesn't exist with ID: " + id);
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(student)) {
                array[i] = updatedStudent;
                return updatedStudent;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void removeAll() {
        for (int i = 0; i < size; i++) {
            array = null;
        }
        size = 0;
    }

    public boolean containsStudents(Object student) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(student)) {
                return false;
            }
        }
        return true;
    }

    public int isEmpty() {
        return size = 0;
    }

    public Object setStudents(Students student, int index) {
        Object student1 = array[index];
        array[index] = student;
        return student1;
    }

    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    public Object[] printStudents() {
        for (int i = 0; i < size-1; i++) {
            Students student = (Students) array[i];
            System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
        }
        return null;
    }
}


