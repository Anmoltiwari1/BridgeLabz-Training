import java.util.*;


class Question {
    private int questionId;
    private String question;
    private String answer;

    Question(int questionId, String question, String answer){
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId(){
        return questionId;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }
}


public class ExamProctor {

    Stack<Integer> navigation = new Stack<>();
    HashMap<Integer,String> answers = new HashMap<>();
    HashMap<Integer,Question> questionBank = new HashMap<>();

    
    public void addQuestion(Question q){
        questionBank.put(q.getQuestionId(), q);
    }

    
    public void visitQuestion(int id){
        if(questionBank.containsKey(id)){
            navigation.push(id);
            System.out.println("Visited Q" + id + ": " +
                    questionBank.get(id).getQuestion());
        } else {
            System.out.println("Question not found");
        }
    }

  
    public void goBack(){
        if(navigation.isEmpty()){
            System.out.println("No previous question");
            return;
        }
        navigation.pop();
        System.out.println("Moved back to previous question");
    }

   
    public void answerQuestion(int id, String ans){
        if(!questionBank.containsKey(id)){
            System.out.println("Invalid Question ID");
            return;
        }
        answers.put(id, ans);
        System.out.println("Answer saved for Q" + id);
    }

    
    public int calculateScore(){
        int score = 0;

        for(int id : answers.keySet()){
            String studentAns = answers.get(id);
            String correctAns = questionBank.get(id).getAnswer();

            if(studentAns.equalsIgnoreCase(correctAns)){
                score++;
            }
        }
        return score;
    }

    public void submitExam(){
        int score = calculateScore();
        System.out.println("\nExam Submitted!");
        System.out.println("Your Score = " + score + "/" + questionBank.size());
    }

   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExamProctor exam = new ExamProctor();

        
        exam.addQuestion(new Question(1,"Java is platform independent? (yes/no)","yes"));
        exam.addQuestion(new Question(2,"2 + 2 = ?","4"));
        exam.addQuestion(new Question(3,"Stack follows LIFO? (yes/no)","yes"));

        int choice;

        do{
            System.out.println("\n--- Online Exam Menu ---");
            System.out.println("1. Visit Question");
            System.out.println("2. Go Back");
            System.out.println("3. Answer Question");
            System.out.println("4. Submit Exam");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.print("Enter Question ID: ");
                    int qid = sc.nextInt();
                    exam.visitQuestion(qid);
                    break;

                case 2:
                    exam.goBack();
                    break;

                case 3:
                    System.out.print("Enter Question ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your answer: ");
                    String ans = sc.nextLine();
                    exam.answerQuestion(id, ans);
                    break;

                case 4:
                    exam.submitExam();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 5);

        sc.close();
    }
}
