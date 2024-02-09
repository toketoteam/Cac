package project001;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Cac extends Frame{

	public static void main(String[] args) {
		Win1 win = new Win1();
	}
}
class Win1 extends Frame{	
	StringBuilder totalExpression = new StringBuilder();
    private String operator = ""; 
    ArrayList<Double> numberList = new ArrayList<>();
    ArrayList<String> operatorList = new ArrayList<>();
    StringBuilder currentNumber = new StringBuilder();
    boolean isCalculationCompleted = false;
    
 
	Font font20 = new Font("TimesRoman", Font.BOLD, 20);
	Font font25 = new Font("TimesRoman", Font.BOLD, 25);
	Font font30 = new Font("TimesRoman", Font.BOLD, 30);
	Font font15 = new Font("TimesRoman", Font.BOLD, 15);
	Font font10 = new Font("TimesRoman", Font.BOLD, 10);
	Label lbTitle = new Label("계산기프로그램");
	Button btnFunc1 = new Button("1");
	Button btnFunc2 = new Button("2");
	Button btnFunc3 = new Button("3");
	Button btnFunc4 = new Button("4");
	Button btnFunc5 = new Button("5");
	Button btnFunc6 = new Button("6");
	Button btnFunc7 = new Button("7");
	Button btnFunc8 = new Button("8");
	Button btnFunc9 = new Button("9");
	Button btnFunc0 = new Button("0");
	Button btnFuncP = new Button("+");
	Button btnFuncM = new Button("-");
	Button btnFuncX = new Button("*");
	Button btnFuncN = new Button("/");
	Button btnFuncE = new Button("=");
	Button btnFuncC = new Button("C");
	TextField tfG = new TextField();
	
	
	
	Win1()
	{
		super("계산기");
		this.setSize(340, 420);//윈도우크기
		init();	//화면구성하기	
		this.setLocation(700, 350);//윈도우실행위치
		this.setVisible(true);
		start();
		btnFunc1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("1");}});
		btnFunc2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("2");}});
		btnFunc3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("3");}});
		btnFunc4.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("4");}});
		btnFunc5.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("5");}});
		btnFunc6.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("6");}});
		btnFunc7.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("7");}});
		btnFunc8.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("8");}});
		btnFunc9.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("9");}});
		btnFunc0.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        appendText("0");}});
		btnFuncP.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	appendText("+");performOperation("+");}});
		btnFuncM.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	appendText("-");performOperation("-");}});
		btnFuncN.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	appendText("/");performOperation("/");}});
		btnFuncX.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	appendText("*");performOperation("*");}});
		btnFuncE.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	performOperation("=");}});
		btnFuncC.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	performOperation("C");}});
		
		
		
		
		
	}
	void init()//화면레이아웃구성
	{
		//프레임에 레이아웃 설정
		this.setLayout(null); //위치 좌표 고정하는 선언
		//컴포넌트 윈도우에 추가
		this.add(lbTitle);
		this.add(btnFunc1);this.add(btnFunc2);this.add(btnFunc3);this.add(btnFunc4);this.add(btnFunc5);
		this.add(btnFunc6);this.add(btnFunc7);this.add(btnFunc8);this.add(btnFunc9);this.add(btnFunc0);
		this.add(btnFuncP);this.add(btnFuncM);this.add(btnFuncX);this.add(btnFuncN);this.add(btnFuncE);
		this.add(btnFuncC);this.add(tfG);
		//글자크기 적용
		lbTitle.setFont(font20);
		btnFunc1.setFont(font15);btnFunc2.setFont(font15);btnFunc3.setFont(font15);btnFunc4.setFont(font15);
		btnFunc5.setFont(font15);btnFunc6.setFont(font15);btnFunc7.setFont(font15);btnFunc8.setFont(font15);
		btnFunc9.setFont(font15);btnFunc0.setFont(font15);
		btnFuncP.setFont(font15);btnFuncM.setFont(font15);btnFuncX.setFont(font15);btnFuncN.setFont(font15);
		btnFuncE.setFont(font15);btnFuncC.setFont(font15);
		tfG.setFont(font15);
		
		//실제적으로 윈도우프레임에 배치해서 위치시키기
		lbTitle.setBounds(100, 30, 150, 30);
		btnFunc1.setBounds(20, 115, 50, 40);btnFunc2.setBounds(90, 115, 50, 40);btnFunc3.setBounds(160, 115, 50, 40);btnFuncP.setBounds(230, 115, 50, 40);
		btnFunc4.setBounds(20, 165, 50, 40);btnFunc5.setBounds(90, 165, 50, 40);btnFunc6.setBounds(160, 165, 50, 40);btnFuncM.setBounds(230, 165, 50, 40);
		btnFunc7.setBounds(20, 215, 50, 40);btnFunc8.setBounds(90, 215, 50, 40);btnFunc9.setBounds(160, 215, 50, 40);btnFuncX.setBounds(230, 215, 50, 40);
		btnFunc0.setBounds(90, 265, 50, 40);
		btnFuncC.setBounds(20, 265, 50, 40);btnFuncN.setBounds(230, 265, 50, 40);btnFuncE.setBounds(160, 265, 50, 40);
		tfG.setBounds(50, 330, 200, 50);
		
	
	}
	
	void appendText(String text) {
	    if (isCalculationCompleted && (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/"))) {
	        totalExpression.setLength(0); // totalExpression 초기화
	        totalExpression.append(numberList.get(0)); // 이전 결과를 totalExpression에 추가
	        totalExpression.append(text); // 입력한 연산자를 totalExpression에 추가
	        tfG.setText(totalExpression.toString()); // totalExpression을 화면에 표시
	        currentNumber.setLength(0); // currentNumber 초기화
	        isCalculationCompleted = false; // 상태를 false로 재설정
	    } else if (isCalculationCompleted && !text.equals("+") && !text.equals("-") && !text.equals("*") && !text.equals("/")) {
	        currentNumber.setLength(0); // currentNumber 초기화
	        totalExpression.setLength(0); // totalExpression 초기화
	        numberList.clear(); // numberList 초기화
	        isCalculationCompleted = false; // 상태를 false로 재설정
	        currentNumber.append(text);
	        totalExpression.append(text);
	        tfG.setText(totalExpression.toString());
	    } else {
	        totalExpression.append(text);
	        tfG.setText(totalExpression.toString());
	        if (!(text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/"))) {
	            currentNumber.append(text);
	        }
	    }
	}



	
	public void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	} //
	
	

	void performOperation(String operation) {
	    if (isCalculationCompleted && !operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
	        currentNumber.setLength(0); // currentNumber 초기화
	        totalExpression.setLength(0); // totalExpression 초기화
	        numberList.clear(); // numberList 초기화
	        operatorList.clear(); // operatorList 초기화
	        tfG.setText(""); // tfG 텍스트 초기화
	        isCalculationCompleted = false; // 상태를 false로 재설정
	    }

	    if (operation.equals("C")) {
	        currentNumber.setLength(0);
	        totalExpression.setLength(0); 
	        numberList.clear();
	        operatorList.clear();
	        tfG.setText("");
	    } else if (operation.equals("=")) {
	        if (currentNumber.length() != 0) {
	            numberList.add(Double.parseDouble(currentNumber.toString()));
	            currentNumber.setLength(0);
	        }

	        if (!numberList.isEmpty()) {
	            double result = numberList.get(0);
	            for (int i = 0; i < operatorList.size(); i++) {
	                String operator = operatorList.get(i);
	                double nextNumber = numberList.get(i + 1);
	                switch (operator) {
	                    case "+":
	                        result += nextNumber;
	                        break;
	                    case "-":
	                        result -= nextNumber;
	                        break;
	                    case "*":
	                        result *= nextNumber;
	                        break;
	                    case "/":
	                        if (nextNumber != 0) {
	                            result /= nextNumber;
	                        } else {
	                            tfG.setText("Error: Division by zero");
	                            return;
	                        }
	                        break;
	                }
	            }
	            operatorList.clear();
	            numberList.clear();
	            numberList.add(result);
	            tfG.setText(String.valueOf(result));
	            isCalculationCompleted = true; // 계산 완료 표시
	        }
	    } else {
	        if (currentNumber.length() != 0) {
	            numberList.add(Double.parseDouble(currentNumber.toString()));
	            currentNumber.setLength(0);
	        }
	        operatorList.add(operation);
	    }
	}

	}


//진짜진짜끝