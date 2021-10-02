SELECT IIF(GRADE < 8, NULL, NAME), GRADE, MARKS
FROM STUDENTS CROSS JOIN GRADES
WHERE MARKS BETWEEN MIN_MARK AND MAX_MARK
ORDER BY GRADE DESC, NAME;