package ex;

public class Bonus {
	
	
	double getBonus(double saleAmount) {
		if(saleAmount > 5000) {
			return saleAmount * 5 /100;
		}
		
		return 0;
		
	}
	
	double getBonus(int unit) {
		if(unit < 25) {
			return unit * 100;
		}else if(unit > 25) {
			return unit * 150;
		}		
		
		return 0;
	}
	
	double getBonus(String employee, int part) {
		if(employee.equals("Part-time")) {
			if(part > 250) {
				return part * 10;
			}
		}else {
			if(part > 700) {
				return part * 10;
			}
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		Bonus bonus = new Bonus();
		
		System.out.println(bonus.getBonus(5001));  
	}

}
