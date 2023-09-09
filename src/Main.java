import service.QuizService;
import service.impl.QuizServiceImpl;

public class Main {
    public static void main(String[] args) {

        QuizService quizService = new QuizServiceImpl();
        quizService.start();

    }
}