package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest() {
        Mockito.when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                new Grade("Harry", "Potions", "C-"),
                new Grade("Hermione", "Arithmancy", "A+")
        ));

        List<Grade> result = gradeService.getGrades();

        Assert.assertEquals("Harry", result.get(0).getName());
        Assert.assertEquals("Arithmancy", result.get(1).getSubject());
    }

    @Test
    public void gradeIndexTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        Mockito.when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        Mockito.when(gradeRepository.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        Assert.assertEquals(0, valid);
        Assert.assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void returnGradeByIdTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        Mockito.when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        Mockito.when(gradeRepository.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);

        Assert.assertEquals(grade, result);
    }

    @Test
    public void addGradeTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        Mockito.when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        Mockito.when(gradeRepository.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade("Hermione", "Arithmancy", "A+");
        gradeService.submitGrade(newGrade);

        Mockito.verify(gradeRepository, Mockito.times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        Mockito.when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        Mockito.when(gradeRepository.getGrade(0)).thenReturn(grade);

        grade.setScore("A-");
        gradeService.submitGrade(grade);

        Mockito.verify(gradeRepository, Mockito.times(1)).updateGrade(grade,  0);
    }
}
