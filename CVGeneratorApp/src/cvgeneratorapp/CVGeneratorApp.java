package cvgeneratorapp;
//importing all the required packages
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
//For Importing upper four packages we need to add itextpdf JAR to our class directory
import java.io.FileNotFoundException;
import java.util.Scanner;
//The upper two functions is used to get input from the user and for exception handling
public class CVGeneratorApp {
    //declare variables to store user input
    private String fullName, address, phone, email, linkedin, website;
    private String degree, institution, eduLocation, graduation;
    private String jobTitle, company, workLocation, employmentDates, responsibilities;

    public CVGeneratorApp() {
        Scanner scanner = new Scanner(System.in);

        // saving Contact Information input by user
        System.out.print("Enter Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter Address: ");
        address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        phone = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        email = scanner.nextLine();

        System.out.print("Enter LinkedIn Profile: ");
        linkedin = scanner.nextLine();

        System.out.print("Enter Website/Portfolio: ");
        website = scanner.nextLine();

        // saving Education Information input by user
        System.out.print("Enter Degree: ");
        degree = scanner.nextLine();

        System.out.print("Enter Institution: ");
        institution = scanner.nextLine();

        System.out.print("Enter Location of Institution: ");
        eduLocation = scanner.nextLine();

        System.out.print("Enter Year of Graduation: ");
        graduation = scanner.nextLine();

        // saving Work Experience input by user
        System.out.print("Enter Job Title: ");
        jobTitle = scanner.nextLine();

        System.out.print("Enter Company Name: ");
        company = scanner.nextLine();

        System.out.print("Enter Location of Company: ");
        workLocation = scanner.nextLine();

        System.out.print("Enter Dates of Employment: ");
        employmentDates = scanner.nextLine();

        System.out.print("Enter Responsibilities and Achievements: ");
        responsibilities = scanner.nextLine();
        //Trying to save input data into pdf 
        try {
            saveCVToPDF();
        } catch (FileNotFoundException e) {
            //Handling error if occur 
            System.err.println("Error creating PDF: " + e.getMessage());
        }
    }

    private void saveCVToPDF() throws FileNotFoundException {
        // Define the destination file path
        String dest = "CV.pdf";
        //Declaring PdfWriter which writes the PDF to specified designation
        PdfWriter writer = new PdfWriter(dest);
        //Declaring PdfDocument that repersent the PDF Document
        PdfDocument pdfDoc = new PdfDocument(writer);
        // Creating PDF to add Data
        try (Document document = new Document(pdfDoc)) {
            // Adding data to the PDF
            document.add(new Paragraph("CV Data"));
            document.add(new Paragraph("Full Name: " + fullName));
            document.add(new Paragraph("Address: " + address));
            document.add(new Paragraph("Phone: " + phone));
            document.add(new Paragraph("Email: " + email));
            document.add(new Paragraph("LinkedIn: " + linkedin));
            document.add(new Paragraph("Website: " + website));
            document.add(new Paragraph("Degree: " + degree));
            document.add(new Paragraph("Institution: " + institution));
            document.add(new Paragraph("Location of Institution: " + eduLocation));
            document.add(new Paragraph("Year of Graduation: " + graduation));
            document.add(new Paragraph("Job Title: " + jobTitle));
            document.add(new Paragraph("Company Name: " + company));
            document.add(new Paragraph("Location of Company: " + workLocation));
            document.add(new Paragraph("Dates of Employment: " + employmentDates));
            document.add(new Paragraph("Responsibilities and Achievements: " + responsibilities));
        }
        //Telling the user that the data is saved in the PDF succesfully
        System.out.println("CV saved as PDF to " + dest);
    }

    public static void main(String[] args) {
        CVGeneratorApp cvGeneratorApp = new CVGeneratorApp();
    }
}
