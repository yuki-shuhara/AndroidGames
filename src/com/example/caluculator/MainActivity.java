package com.example.caluculator;

//import com.example.caluculator.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView view, history;
	private Button number1, number2, number3, number4, number5, number6, number7, number8, number9, number0;
	private Button addition, subtraction, multiplication, division, answer, reverse, memadd, memsub, mem, memcle;
	private Button clear, dot;
	
	private enum operator{add, sub, mul, div, non, };
	private operator now = operator.non;
	private double prev = 0;
	private boolean reset, dotflag;
	private double memory = 0;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        reset = false;
        dotflag = false;
        
        view = (TextView) findViewById(R.id.textView1);
        view.setGravity(Gravity.RIGHT);
        view.setText("0");
        
        history = (TextView) findViewById(R.id.textView2);
        history.setGravity(Gravity.RIGHT);
        history.setText("");
        
        number0 = (Button) findViewById(R.id.button22);
        number0.setOnClickListener(this);
        
        number1 = (Button) findViewById(R.id.button18);
        number1.setOnClickListener(this);
        
        number2 = (Button) findViewById(R.id.button19);
        number2.setOnClickListener(this);        

        number3 = (Button) findViewById(R.id.button20);
        number3.setOnClickListener(this);
       
        number4 = (Button) findViewById(R.id.button15);
        number4.setOnClickListener(this);

        number5 = (Button) findViewById(R.id.button16);
        number5.setOnClickListener(this);
        
        number6 = (Button) findViewById(R.id.button17);
        number6.setOnClickListener(this);

        number7 = (Button) findViewById(R.id.button12);
        number7.setOnClickListener(this);
        
        number8 = (Button) findViewById(R.id.button13);
        number8.setOnClickListener(this);
        
        number9 = (Button) findViewById(R.id.button14);
        number9.setOnClickListener(this);
        
        addition = (Button) findViewById(R.id.button10);
        addition.setOnClickListener(this);
        
        subtraction = (Button) findViewById(R.id.button9);
        subtraction.setOnClickListener(this);
        
        multiplication = (Button) findViewById(R.id.button8);
        multiplication.setOnClickListener(this);
        
        division = (Button) findViewById(R.id.button7);
        division.setOnClickListener(this);
        
        answer = (Button) findViewById(R.id.button11);
        answer.setOnClickListener(this);
        
        clear = (Button) findViewById(R.id.button5);
        clear.setOnClickListener(this);
        
        reverse = (Button) findViewById(R.id.button6);
        reverse.setOnClickListener(this);
        
        dot = (Button) findViewById(R.id.button23);
        dot.setOnClickListener(this);
    
        //Memory
        memcle= (Button) findViewById(R.id.button1);
        memcle.setOnClickListener(this);
        
        memadd = (Button) findViewById(R.id.button4);
        memadd.setOnClickListener(this);
        
        memsub = (Button) findViewById(R.id.button3);
        memsub.setOnClickListener(this);
        
        mem = (Button) findViewById(R.id.button2);
        mem.setOnClickListener(this);
        
        
        
    }
    
    
    @Override
    public void onClick(View v){
    	
    	if(reset) history.setText("");
    	
    	String hist = (String) history.getText().toString();
    	String str = (String) view.getText().toString();
    	
    	switch(v.getId()){
    	case R.id.button1:
    		memory = 0;
    		return;
   
    	case R.id.button2:
    		memory = Double.parseDouble(str);
    		return;
    		
    	case R.id.button3:
    		prev = memory;
    		now = operator.sub;
    		view.setText("");
    		hist += "mem - ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    		
    	case R.id.button4:
    		prev = memory;
    		now = operator.add;
    		view.setText("");
    		hist += "mem + ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    	}
    	
    	

    	
    	switch(v.getId()){
    	
    	case R.id.button11://answer
    		double ans = 0;
    		if(str.length() == 0) {
    			ans = 0;
    		}
    		
    		else{
	    		switch(now){//operator is...
	    		case add:
	    			ans = prev+Double.parseDouble(str);
	    			break;
	    			
	    		case sub:
	    			ans = prev-Double.parseDouble(str);
	    			break;
	    		
	    		case mul:
	    			ans = prev*Double.parseDouble(str);
	    			break;
	    			
	    		case div:
	    			ans = prev/Double.parseDouble(str);
	    			break;
	    			
	    		case non:
	    			ans = prev;
	    			break;
	    		}
    		}
    		hist += str;
			view.setText(Double.toString(ans));
			history.setText(hist);
			prev = ans;
			reset = true;
    		dotflag = false;
    		return;
    		
    	case R.id.button10://addition
    		prev = Double.parseDouble(str);
    		now = operator.add;
       		view.setText("");
    		hist += str + " + ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    		
    	case R.id.button9://subtraction
    		prev = Double.parseDouble(str);
    		now = operator.sub;
    		view.setText("");
    		hist += str + " - ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    		
    	case R.id.button8://multiplication
    		prev =  Double.parseDouble(str);
    		now = operator.mul;
    		view.setText("");
    		hist += str + " * ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    		
    	case R.id.button7://division
    		prev = Double.parseDouble(str);
    		now = operator.div;
    		view.setText("");
    		hist += str + " / ";
    		history.setText(hist);
    		reset = false;
    		dotflag = false;
    		return;
    		
    	case R.id.button5://clear
    		view.setText("0");
    		history.setText("");
    		now = operator.non;
    		prev = 0;
    		reset = false;
    		dotflag = false;
    		return;    	
    		
    	case R.id.button6://reverse
    		str = Double.toString((Double.parseDouble(str) * -1));
    		view.setText(str);
    		return;
    	}
    	
    	if(reset){
    		history.setText("");
    		hist = "";
    		view.setText("");
    		str = "";
    		reset = false;
    		dotflag = false;
    	}
    	
    	if(str.length() > 10){

    	}
    	else{    	
	    	switch(v.getId()){
	    	case R.id.button22://0
	    		str += 0;
	    		
	    		break;
	
	    	case R.id.button18://1
	    		str += 1;
	    		
	    		break;
	    		
	    	case R.id.button19://2
	    		str += 2;
	    		
	    		break;
	    		
	    	case R.id.button20://3
	    		str += 3;
	    		
	    		break;
	    		
	    	case R.id.button15://4
	    		str += 4;
	    		
	    		break;
	    		
	    	case R.id.button16://5
	    		str += 5;
	    		
	    		break;
	    		
	    	case R.id.button17://6
	    		str += 6;
	    		
	    		break;
	    		
	    	case R.id.button12://7
	    		str += 7;
	    		
	    		break;
	    		
	    	case R.id.button13://8
	    		str += 8;
	    		
	    		break;
	    		
	    	case R.id.button14://9
	    		str += 9;
	    			
	    		break;
	    		
	    	case R.id.button23://.
	    		if(!dotflag){
	    			str+= ".";
	    			dotflag = true;
	    		}
	    		break;
	    	}
    	}
    	double tmp = Double.parseDouble(str);
    	str = Double.toString(tmp);
    	view.setText(str);
    }
    
    
    
}