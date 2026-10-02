package schoolInformationsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolInformationsystem.demo.model.ExamResult;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    // Fetch marks by exam and subject
    List<ExamResult> findByExam_ExamIdAndSubject_SubjectId(String examId, String subjectId);

    // Fetch all marks for a student in a specific exam
    List<ExamResult> findByStudent_StudentIdAndExam_ExamId(String studentId, String examId);

    // Fetch all results for a given exam
    List<ExamResult> findByExam_ExamId(String examId);

    // Find specific result for upsert (Update or Insert)
    Optional<ExamResult> findByExam_ExamIdAndStudent_StudentIdAndSubject_SubjectId(String examId, String studentId, String subjectId);
}