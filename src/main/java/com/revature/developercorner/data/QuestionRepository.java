package com.revature.developercorner.data;

import com.revature.developercorner.entity.Question;
import com.revature.developercorner.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

