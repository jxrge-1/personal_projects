public class Main {
    public static void main(String[] args) {

    Employee tim = new Employee("Time", "06/11/2001", "01/01/2019");
        System.out.println(tim);
        System.out.println("Age: " + tim.getAge());
        System.out.println("pay: " + tim.collectPay());
        System.out.println("--------------------------------");

    Employee joey = new Employee("joey", "11/11/2000", "01/21/2020");
        System.out.println(joey);
        System.out.println("--------------------------------");

    HourlyEmployee jorge = new HourlyEmployee
            ("jorge", "06/11/2001",
            "09/30/2023", 30);
        System.out.println(jorge);
        System.out.println("--------------------------------");

    SalariedEmployee akos = new SalariedEmployee("Akos",
                    "01/0/1999", "06/10/2023", 50000);
        System.out.println(akos);
        System.out.println("Akos' paycheck = $" + akos.collectPay());
        akos.retire();
        System.out.println("Akos' pension check = $" + akos.collectPay());
        System.out.println("--------------------------------");

    HourlyEmployee mary = new HourlyEmployee("Mary", "05/11/2000",
                      "03/12/2023", 15);
        System.out.println(mary);
        System.out.println("Mary check = $" + mary.collectPay());
        System.out.println("Mary holiday check = $" + mary.getDoublePay());
    }
}
