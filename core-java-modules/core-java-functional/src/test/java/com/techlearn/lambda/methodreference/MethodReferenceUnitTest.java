package com.techlearn.lambda.methodreference;

import com.techlearn.lambda.lambda.methodreference.Student;
import com.techlearn.lambda.lambda.methodreference.StudentGradeComparator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class MethodReferenceUnitTest {

    @Test
    public void referenceToStaticMethod() {
        List<String> messages = Arrays.asList("Hello", "Baeldung", "readers!");
        messages.forEach(word -> StringUtils.capitalize(word));
        messages.forEach(StringUtils::capitalize);
    }

    @Test
    public void referenceToInstanceMethodOfParticularObject() {
        StudentGradeComparator studentGradeComparator = new StudentGradeComparator();
        createStudentList().stream()
                .sorted((a,b) -> studentGradeComparator.compare(a,b));
        createStudentList().stream()
                .sorted(studentGradeComparator::compare);
    }

    @Test
    public void referenceToInstanceMethodOfArbitraryObjectOfParticularType() {
        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        numbers.stream()
                .sorted((a, b) -> a.compareTo(b));
        numbers.stream()
                .sorted(Integer::compareTo);
    }

    @Test
    public void referenceToConstructor() {
        BiFunction<String, Integer, Student> studentCreator = (name, grade) -> new Student(name,grade);
        BiFunction<String, Integer, Student> studentCreatorMethodReference = Student::new;

        List<Student> students = new ArrayList<>();
        students.add(studentCreator.apply("suku", 66));
        students.add(studentCreatorMethodReference.apply("jhon", 90));
    }

    @Test
    public void referenceToConstructorSimpleExample() {
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        bikeBrands.stream()
                .map(Student::new)
                .toArray(Student[]::new);
    }

    @Test
    public void limitationsAndAdditionalExamples() {
        createStudentList().forEach(b -> System.out.printf("'%s' grade is '%d'%n", b.getName(), b.getGrade()));
    }

    private List<Student> createStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Suku", 50));
        students.add(new Student("Jhon", 20));
        students.add(new Student("Abhi", 35));
        students.add(new Student("Leo", 40));
        return students;
    }

}
