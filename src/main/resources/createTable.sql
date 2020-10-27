CREATE TABLE java_quiz.Question(
id BIGINT NOT NULL PRIMARY KEY,
question TEXT
);

CREATE TABLE java_quiz.Answer(
id BIGINT NOT NULL PRIMARY KEY,
questionId BIGINT,
answerText TEXT,
isCorrect BOOLEAN,
FOREIGN KEY (questionId) REFERENCES java_quiz.Question(id));
);