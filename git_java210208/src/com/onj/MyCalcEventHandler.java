package com.onj;														
														
import java.awt.event.ActionEvent;														
import java.awt.event.ActionListener;														
														
import javax.swing.JButton;														
import javax.swing.JTextField;														
														
public class MyCalcEventHandler implements ActionListener{														
	private JTextField jtf_result = null;													
	private JButton jbt_one = null;													
	private JButton jbt_two = null;													
	private JButton jbt_plus = null;													
	private JButton jbt_equals = null; 													
	private JButton jbt_clear = null; 													
	String v1 = "";													
	String v2 = "";													
	String op = "";													
	public MyCalcEventHandler(){													
														
	}													
	public XXXXXXXXXXXXXXXX(JTextField jtf_result, JButton jbt_one, JButton jbt_two, JButton jbt_plus, JButton jbt_equals, JButton jbt_clear){													
		this.jtf_result = jtf_result;												
		this.jbt_one = jbt_one;												
		this.jbt_two = jbt_two;												
		this.jbt_plus = jbt_plus;												
		this.jbt_equals = jbt_equals;												
		this.jbt_clear = jbt_clear;												
	}													
	@Override													
	public void actionPerformed(ActionEvent ae) {													
		Object obj = ae.getSource();												
														
		if(obj == jbt_XXX){												
			jtf_result.setText(XXX_XXXXX.getText()+"1");											
		}else if(obj == jbt_XXX){												
			jtf_result.XXXXXXX(jtf_result.getText()+"2");											
		}else if(obj == jbt_plus){												
			v1 = jtf_result.getText();											
			System.out.println("v1 : "+v1);											
			op = "?";											
			jtf_result.setText("");											
		}else if(obj == jbt_XXXXXX){												
			XX = XXX_XXXXXX.getText();											
			System.out.println("v1:"+v1 +"-> v2 : "+v2+" op : "+op);											
			String result = MyCalcurate.XXXXXXX(v1,v2,op);											
			jtf_result.setText(XXXXXX);											
		}else if(obj == jbt_clear){												
			jtf_result.setText("");											
		}												
	}													
														
}														
														
														
														
														
