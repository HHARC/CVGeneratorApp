package cvgeneratorapp;
//importing all the required packages
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
//For Importing upper 2 packages we need to add itextpdf JAR to our class directory
import java.io.ByteArrayInputStream;
//Allows reading data as a stream of bytes from a byte array.
import java.io.IOException;
//For Handling IO Exception
import java.nio.charset.StandardCharsets;
// Defines constant values for various character sets.
import java.util.Scanner;
//For taking input from the user

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

        // Saving Education Information input by user
        System.out.print("Enter Degree: ");
        degree = scanner.nextLine();

        System.out.print("Enter Institution: ");
        institution = scanner.nextLine();

        System.out.print("Enter Location of Institution: ");
        eduLocation = scanner.nextLine();

        System.out.print("Enter Year of Graduation: ");
        graduation = scanner.nextLine();

        // Saving Work Experience input by user
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

        // Close scanner to prevent resource leak
        scanner.close();
        //Trying to save input data into pdf
        try {
            saveCVToPDF();
        } catch (IOException e) {
            System.err.println("Error creating PDF: " + e.getMessage());
        }
    }

    private void saveCVToPDF() throws IOException {
        // Define the destination file path
        String dest = "CV.pdf";
        //Declaring PdfWriter which writes the PDF to specified designation
        PdfWriter writer = new PdfWriter(dest);

        // Constructing the HTML content with inline CSS styles
        String htmlContent = "<html><head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; margin: 20px; }" +
                "h1 { color: #333333; }" +
                "h2 { color: #555555; }" +
                "p { margin-bottom: 10px; }" +
                "strong { color: #007bff; }" +
                "</style>" +
                "</head><body>" +
                "<h1>CV Data</h1>" +
                "<h2>Contact Information</h2>" +
                "<p><strong>Full Name:</strong> " + fullName + "</p>" +
                "<p><strong>Address:</strong> " + address + "</p>" +
                "<p><strong>Phone:</strong> " + phone + "</p>" +
                "<p><strong>Email:</strong> " + email + "</p>" +
                "<p><strong>LinkedIn:</strong> " + linkedin + "</p>" +
                "<p><strong>Website:</strong> " + website + "</p>" +
                "<h2>Education Information</h2>" +
                "<p><strong>Degree:</strong> " + degree + "</p>" +
                "<p><strong>Institution:</strong> " + institution + "</p>" +
                "<p><strong>Location:</strong> " + eduLocation + "</p>" +
                "<p><strong>Year of Graduation:</strong> " + graduation + "</p>" +
                "<h2>Work Experience</h2>" +
                "<p><strong>Job Title:</strong> " + jobTitle + "</p>" +
                "<p><strong>Company Name:</strong> " + company + "</p>" +
                "<p><strong>Location of Company:</strong> " + workLocation + "</p>" +
                "<p><strong>Dates of Employment:</strong> " + employmentDates + "</p>" +
                "<p><strong>Responsibilities and Achievements:</strong> " + responsibilities + "</p>" +
                "</body></html>";

        // Converting HTML content to PDF
        HtmlConverter.convertToPdf(new ByteArrayInputStream(htmlContent.getBytes(StandardCharsets.UTF_8)), writer);

        System.out.println("CV saved as PDF to " + dest);
    }

    public static void main(String[] args) {
        CVGeneratorApp cvGeneratorApp = new CVGeneratorApp();
    }
}
