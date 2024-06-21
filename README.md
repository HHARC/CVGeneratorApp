# CV Generator Application

## Introduction

Welcome to the CV Generator Application! This project is designed to help you create a PDF CV using Java. The program collects user input for various sections of a CV and generates a formatted PDF document.

## Prerequisites

Before running the project, ensure you have the following:
- Java Development Kit (JDK) installed
- iText library included in your project

## Setting Up the Project

1. **Download the iText Library:**
   - Download the iText library JAR file from the [iText website](https://itextpdf.com/en/products/itext-7/itext-7-core).

2. **Include the iText JAR in NetBeans:**
   - In NetBeans, right-click on your project and select `Properties`.
   - Go to `Libraries` and click `Add JAR/Folder`.
   - Select the iText JAR file you downloaded.

## How to Use the CV Generator Application

1. **Start the Application:**
   - Run the application in NetBeans.

2. **Enter Contact Information:**
   - The application will prompt you to enter your full name, address, phone number, email address, LinkedIn profile, and website/portfolio.

3. **Enter Education Information:**
   - Provide details about your degree, institution, location of the institution, and year of graduation.

4. **Enter Work Experience:**
   - Input information about your job title, company name, location of the company, dates of employment, and responsibilities and achievements.

5. **Generate PDF:**
   - After entering all the required information, the application will generate a PDF file named `CV.pdf` in your project directory with the CV data.

## Main Code Explanation

Here is a brief explanation of the key lines in the CV Generator Application:

```java
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
import java.io.FileNotFoundException;
import java.util.Scanner;
```
- These import statements bring in the necessary classes from the iText library and Java standard library to handle PDF creation and user input.

```java
public class CVGeneratorApp {
    private String fullName, address, phone, email, linkedin, website;
    private String degree, institution, eduLocation, graduation;
    private String jobTitle, company, workLocation, employmentDates, responsibilities;
```
- Declaration of private variables to store user input for different sections of the CV.

```java
public CVGeneratorApp() {
    Scanner scanner = new Scanner(System.in);
    // Code to collect user input
}
```
- Constructor of the `CVGeneratorApp` class where a `Scanner` object is used to collect user input.

```java
private void saveCVToPDF() throws FileNotFoundException {
    String dest = "CV.pdf";
    PdfWriter writer = new PdfWriter(dest);
    PdfDocument pdfDoc = new PdfDocument(writer);
    try (Document document = new Document(pdfDoc)) {
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
    System.out.println("CV saved as PDF to " + dest);
}
```
- The `saveCVToPDF` method creates a PDF file using the iText library. It initializes a `PdfWriter` and `PdfDocument`, and then adds paragraphs with the user-provided data to the PDF document.

```java
public static void main(String[] args) {
    CVGeneratorApp cvGeneratorApp = new CVGeneratorApp();
}
```
- The `main` method instantiates the `CVGeneratorApp` class, triggering the constructor and subsequently generating the PDF.

## Conclusion

Thank you for using the CV Generator Application! This project helps you practice Java programming while creating a useful tool. Keep coding, stay curious, and enjoy the journey of programming! Happy coding!
``
