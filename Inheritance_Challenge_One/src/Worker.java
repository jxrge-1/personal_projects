public class Worker {
    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(){//Default constructor

    }
    public Worker(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    public int getAge(){
        int year = 2023;
        int birthYear = Integer.parseInt
                (birthDate.substring(6));
                //Recall: the Integer.parseInt converts String into int
        return (year - birthYear);
    }

    public double collectPay(){
        return 0;
    }
    public void terminate(String endDate){
        System.out.println(this.name +
                " was terminated on: "
                + endDate);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
