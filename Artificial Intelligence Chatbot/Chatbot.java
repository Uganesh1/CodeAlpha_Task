import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I’m CodeAlphaBot. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.contains("exit")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            } else if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hi there! How can I help you today?");
            } else if (input.contains("how are you")) {
                System.out.println("Bot: I'm doing well, thank you! How about you?");
            } else if (input.contains("your name")) {
                System.out.println("Bot: I’m CodeAlphaBot, your virtual assistant.");
            } else if (input.contains("what can you do")) {
                System.out.println("Bot: I can answer simple questions, tell jokes, and give basic help!");
            } else if (input.contains("joke")) {
                System.out.println("Bot: Why don't programmers like nature? It has too many bugs!");
            } else if (input.contains("help")) {
                System.out.println("Bot: You can ask me things like 'Tell me a joke', 'What’s your name?', or 'How are you?'");
            } else if (input.contains("time")) {
                System.out.println("Bot: Sorry, I can't tell real time yet. Ask your system clock!");
            } else if (input.contains("weather")) {
                System.out.println("Bot: I can't fetch live weather data yet, but it's always sunny in code!");
            } else if (input.contains("bye")) {
                System.out.println("Bot: Bye! Hope to chat with you again soon.");
                break;
            } else {
                System.out.println("Bot: I’m not sure how to respond to that. Type 'help' for suggestions.");
            }
        }

        scanner.close();
    }
}
