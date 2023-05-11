import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EmployeeSalary extends JFrame{
    //declare GUI Component
    private JLabel rateLabel,hoursLabel, taxLabel;
    private JTextField textRate,textHours,textSalary, textTax;
    private JButton button;
    private double monthlySalary;
    public EmployeeSalary()  {
        setTitle("Employee Salary Calculator");
        setLayout(new FlowLayout());
        setLocation(500, 200);

        rateLabel = new JLabel("Enter rate per Hour: ");
        textRate = new JTextField(20);
        rateLabel.setFont(new Font(null, Font.ITALIC,15));
        add(rateLabel);
        add(textRate);

        hoursLabel = new JLabel("Enter Hours worked: ");
        textHours = new JTextField(20);
        hoursLabel.setFont(new Font(null, Font.ITALIC,15));
        add (hoursLabel);
        add(textHours);

        taxLabel = new JLabel("Enter Tax: ");
        textTax = new JTextField(20);
        taxLabel.setFont(new Font(null, Font.ITALIC,15));
        add (taxLabel);
        add(textTax);

        textSalary = new JTextField();
        textSalary.setEditable(false);

        button = new JButton ("Calculate");
        button.setBackground(Color.PINK);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                double rate = Double.parseDouble(textRate.getText());
                double hours = Double.parseDouble(textHours.getText());
                monthlySalary = rate * hours;

                if (textTax.getText().contains(".")){
                    //to calculate the take home pay
                    double employeeTax = Double.parseDouble(textTax.getText());
                    double takeHomePay = monthlySalary - getTax(employeeTax);
                    JOptionPane.showMessageDialog(null, "TAKE HOME PAY: $ " + takeHomePay);
                }
                else {
                    int taxTax = Integer.parseInt(textTax.getText());
                    double takeHomePay = monthlySalary - getTax(taxTax);
                    JOptionPane.showMessageDialog(null, "TAKE HOME PAY: $ " + takeHomePay);
                }
            }

        });
        add(button);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.ORANGE);

    }
    //a method that accept double
    public double getTax(double employeeTax){
        return monthlySalary * employeeTax;
    }
    //a method that accept integer
    public double getTax(int taxTax){
        double empTax = taxTax / 100.0;
        return monthlySalary * empTax;
    }
    public static void main(String[] args) {
        new EmployeeSalary();


    }
}
