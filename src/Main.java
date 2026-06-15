import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GeminiClient client = new GeminiClient();

        System.out.println("==================================");
        System.out.println("      Gemini AI ChatBot");
        System.out.println("Type 'exit' to quit");
        System.out.println("==================================");

        while(true) {
            System.out.println("\nYou : ");
            String prompt = sc.nextLine();
            if(prompt.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                
                    if (prompt.toLowerCase().startsWith("send email")) {

                        System.out.println("\n✉ Email Mode Activated");

                        System.out.println("\nDescribe your email:");

                        String emailPrompt = sc.nextLine();

                        // Send to Gemini for structured email
                        String systemPrompt =
                                "You are an email writer. " +
                                "Return ONLY in this format:\n\n" +
                                "SUBJECT: <subject>\n" +
                                "BODY: <body>\n\n" +
                                "User request:\n" + emailPrompt;

                        String json = client.askGemini(systemPrompt);
                        String response = ResponseParser.extractText(json);

                        System.out.println("\n========== EMAIL PREVIEW ==========\n");
                        System.out.println(response);
                        System.out.println("\n===================================");

                        System.out.print("\nReceiver Email: ");
                        String receiver = sc.nextLine();

                        System.out.print("Send this email? (Y/N): ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {

                            System.out.print("Your Gmail: ");
                            String sender = sc.nextLine();

                            System.out.print("App Password: ");
                            String password = sc.nextLine();

                            // simple parsing
                            String subject = "";
                            String body = "";

                            if (response.contains("SUBJECT:") && response.contains("BODY:")) {
                                subject = response.split("SUBJECT:")[1].split("BODY:")[0].trim();
                                body = response.split("BODY:")[1].trim();
                            }

                            EmailService.sendEmail(
                                    sender,
                                    password,
                                    receiver,
                                    subject,
                                    body
                            );

                        } else {
                            System.out.println("Email cancelled.");
                        }

                        continue;
                    }
                
                String json = client.askGemini(prompt);
                String answer = ResponseParser.extractText(json);
                System.out.println("\nGemini : "+answer);
            } 
            catch(Exception e) {
                System.out.println("\nError : "+e.getMessage());
            }
        }
        sc.close();
        System.out.println("\nGoodbye!");
    }
}