public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate,
                            String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }
@Override
public double collectPay(){
        double paycheck = annualSalary / 26;
        paycheck = (isRetired) ? 0.9 * paycheck : paycheck;
        return (int) paycheck;
}
    public void retire(){
        terminate("12/12/2030");
        isRetired = true;
    }
}
