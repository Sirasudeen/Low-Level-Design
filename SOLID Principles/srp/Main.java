package srp;

public class Main {
    public static void  main(String[] args)
    {
            Employee e1 = new Employee("Siras","sirasudeenp@gmail.com");
            
            EmployeeRepo empRepo = new EmployeeRepo();
            EmailService empEmailService = new EmailService();

            empRepo.saveEmployee(e1);
            empEmailService.sendReport(e1);
            
     }
}
