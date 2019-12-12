package leb.org;
import java.util.*;
public class StudentMarks {
	Float[] ClassAverage = new Float[1];
	Float[] StudentAverage = new Float[5];
	Float[] TestAverage = new Float[3];
	Integer[][] Score = new Integer[5][3];
	Scanner scan = new Scanner(System.in);
	int RunningTotal = 0, ExitFunctionLoop = 0;
	float ClassAve;
	float StudentAverageFunc(Integer [][] Score , int counter) {
		float StudentAve = (float) ((Score[counter][0] + Score[counter][1] + Score[counter][2]) / 3.0);
		return StudentAve;
	}
	float TestAverageFunc(Integer [][] Score , int counter) {
		float TestAve = (float) (float) ((float) (Score[0][counter] + Score[1][counter] + Score[2][counter] + Score[3][counter] + Score[4][counter]) / 5.0);
		return TestAve;
	}
	int TotalFunc(Integer[][] Score, int counter, int counter2, int RunningTotal) {
		RunningTotal = RunningTotal + Score[counter][counter2];
		return RunningTotal;
	}
	float ClassAverageFunc(int RunningTotal) {
		ClassAve = (float) (RunningTotal / 15.0);
		return ClassAve;
	}
	int UserInput(boolean InputComplete, boolean CalculateComplete) {
		boolean ValidInput = false;
		while (ValidInput == false) {
			System.out.println("Pick an option (Enter: 1 - 4)");
			System.out.println("1. Enter Marks");
			System.out.println("2. Calculate Averages");
			System.out.println("3. Display Averages");
			System.out.println("4. Exit Program");
			int Option = scan.nextInt();
			if (Option == 1) {
				ValidInput = true;
				return Option;
			}else if (Option == 2 && InputComplete == true) {
				ValidInput = true;
				return Option;
			}else if (Option == 3 && CalculateComplete == true) {
				ValidInput = true;
				return Option;
			}else if (Option == 4) {
				ValidInput = true;
				return Option;
			}else {
				System.out.println("Enter a number between 1 and 4 for option");
				System.out.println("Or make sure you have completed previous options before advancing!");
			}
		}
		return ExitFunctionLoop;
	}
	public StudentMarks() {
		// TODO Auto-generated constructor stub
		boolean InputComplete = false, CalculateComplete = false, ExitProgram = false;
		while (ExitProgram == false) {
			int Opinion = UserInput(InputComplete,CalculateComplete);
			if (Opinion == 1) {
				InputScores();
				InputComplete = true;
			}else if(Opinion == 2) {
				for (int counter = 0; counter <= 4; counter++) {
					StudentAverage[counter] = StudentAverageFunc(Score, counter);
				}
				for (int counter = 0; counter <= 2; counter++) {
					TestAverage[counter] = TestAverageFunc(Score, counter);
				}
				for (int counter = 0; counter <= 4; counter++) {
					for (int counter2 = 0; counter2 <= 2; counter2++) {
						RunningTotal = TotalFunc(Score,counter,counter2,RunningTotal);
					}
				}
				ClassAverage[0] = ClassAverageFunc(RunningTotal);
				CalculateComplete = true;
			}else if (Opinion == 3) {
				for(int i = 0; i <= 4; i++) {
					OutputStudentAve(StudentAverage,i);
				}
				System.out.println();
				for(int i = 0; i <= 2; i++) {
					OutputTestAve(TestAverage,i);
				}
				OutputClassAve(ClassAverage);
				System.out.println();
			}else if(Opinion == 4) {
				ExitProgram = true;
			}
		}
	}
	void InputScores() {
		int TestScore;
		for (int i = 0; i <= 4; i++) {
			System.out.println("Enter Student "+ (i + 1) +"'s Scores:");
			for (int j = 0; j <= 2; j ++) {
				do {
					TestScore = scan.nextInt();
					Score[i][j] = TestScore;
					if (TestScore > 40 || TestScore <0) {
					System.out.println("Invalid Input (Range 0 - 40)");
					}
				}while (TestScore >40 || TestScore <0);
			}
		}
	}
	void OutputClassAve(Float [] ClassAverage) {
		System.out.println();
		System.out.printf ("Class average was %.2f",ClassAverage[0]);
	}
	void OutputTestAve(Float [] TestAverage,int i) {
		System.out.printf ("Test "+(i+1)+" average was %.2f",TestAverage[i]);
		System.out.println();
	}
	void OutputStudentAve(Float [] StudentAverage, int i) {
		float TwoDecimalPlaces = StudentAverage[i];
		System.out.printf ("Student "+(i+1)+"'s average was %.2f",TwoDecimalPlaces);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMarks StudentMarks = new StudentMarks();
	}
}
