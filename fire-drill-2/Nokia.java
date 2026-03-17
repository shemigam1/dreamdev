import java.util.Scanner;

public class Nokia{
  public static void main(String... args){
    String sysPrompt = """
      Welcome to your Nokia map, time to relive your glory days
      Use the Map to navigate around, take in the sights

      Press any number to proceed
      """;
    System.out.println(sysPrompt);
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    MainMenu();
  }

  private static void MainMenu(){
    String prompt = """
      Nokia Main Map
      Press 1 -> Phone Book
      Press 2 -> Messages
      Press 3 -> Chat
      Press 4 -> Call Register
      Press 5 -> Tones
      Press 6 -> Settings
      Press 7 -> Call Divert
      Press 8 -> Games
      Press 9 -> Calculator
      Press 10 -> Reminders
      Press 11 -> Clock
      Press 12 -> Profiles
      Press 13 -> SIM Services
      Press 0 -> Go back
      """;

    System.out.println(prompt);
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();

    switch(input) {
      case 1-> {
        String phonePrompt = """
          Press 1 -> Search
          Press 2 -> Service Nos.
          Press 3 -> Add name
          Press 4 -> Erase
          Press 5 -> Edit
          Press 6 -> Assign Tone
          Press 7 -> Send b'card
          Press 8 -> Options
          Press 9 -> Speed dials
          Press 10 -> Voice tags
          Press 0 -> Go back
          """;
        int phoneBook = scanner.nextInt();
        switch (phoneBook) {
          case 1-> System.out.println("Search");
          case 2-> System.out.println("Service Nos.");
          case 3-> System.out.println("Add name");
          case 4-> System.out.println("Erase");
          case 5-> System.out.println("Edit");
          case 6-> System.out.println("Assign Tone");
          case 7-> System.out.println("Send b'card");
          case 8-> {
            String phonePrompt = """
          Press 1 -> Type of view
          Press 2 -> Memory status
          Press 0 -> Go back
          """;
            int optionsInput = scanner.nextInt();
            switch (optionsInput) {
              case 1-> System.out.println("Type of view");
              case 2-> System.out.println("Memory status");
          }
          case 9-> System.out.println("Speed dials");
          case 10-> System.out.println("Voice tags");
        }
      }
      case 2-> {
        String messagesPrompt = """
          Press 1 -> Write Messages
          Press 2 -> Inbox
          Press 3 -> Outbox
          Press 4 -> Picture Messages
          Press 5 -> Templates
          Press 6 -> Smileys
          Press 7 -> Message settings
          Press 0 -> Go back
          """;
        System.out.prineln(messagesPrompt);
        int messages = scanner.nextInt();
        switch (messages) {
          case 1-> System.out.println("Write Messages");
          case 2-> System.out.println("Inbox");
          case 3-> System.out.println("Outbox");
          case 4-> System.out.println("Picture Messages");
          case 5-> System.out.println("Templates");
          case 6-> System.out.println("Smileys");
          case 7-> {
            String setingsPrompt = """
              Press 1 -> Message centre number
              Press 2 -> Message sent as
              Press 3 -> Message validity
            """;
            System.out.prineln(settingsPrompt);
            int settings = scanner.nextInt();
            switch (settings) {
              case 1-> System.out.println("Message centre number");
              case 2-> System.out.println("Message sent as");
              case 3-> System.out.println("Message validity");
          }
        }

      }
      case 3-> System.out.println("Chat");
      case 4-> {
        String callRegisterPrompt = """
          Press 1 -> Missed calls
          Press 2 -> Received calls
          Press 3 -> Dialed numbers
          Press 4 -> Erase recent call list
          Press 5 -> Show call duration
          Press 6 -> Show call costs
          Press 7 -> Call cost settings
          Press 8 -> Prepaid credit
          Press 0 -> Go back
          """;
        int phoneBook = scanner.nextInt();
        switch (phoneBook) {
          case 1-> System.out.println("Missed calls");
          case 2-> System.out.println("Received calls");
          case 3-> System.out.println("Dialed numbers ");
          case 4-> System.out.println("Erase recent call list");
          case 5-> {
            String durationPrompt = """
              Press 1-> Last call duration
              Press 2 -> All calls' duration
              Press 3 -> Receive calls' duration
              Press 4 -> Dialled calls' duration
              Press 5 -> Clear timers
              """;
            System.out.println(durationPrompt);
            int durationInput = scanner.nextInt();
            switch (durationInput) {
              case 1-> System.out.println("Last call duration");
              case 2-> System.out.println("All calls' duration");
              case 3-> System.out.println("Receive calls' duration");
              case 4-> System.out.println("Dialled calls' duration");
              case 5-> System.out.println("Clear timers");
            }
          }
          case 6-> {
            String costPrompt = """
                  Press 1-> Last call cost
                  Press 2 -> All calls' cost
                  Press 3 -> Clear counters
                  """;
                System.out.println(costPrompt);
                int costInput = scanner.nextInt();
                 switch (costInput) {
                   case 1-> System.out.println("Last call cost");
                   case 2-> System.out.println("All calls' cost");
                   case 3-> System.out.println("Clear counters");
                 }
          }
          case 7-> {
            String callSettings = """
                Press 1 -> Call cost limit
                Press 2 -> Show costs in
              """;
            System.out.println(callSettings);
            int optionsInput = scanner.nextInt();
            switch (optionsInput) {
              case 1-> System.out.println("Type of view");
              case 2-> System.out.println("Memory status");
          }
          case 8-> System.out.println("Prepaid credit");
        }

      }
      //case 5-> Tones();
      //case 6-> Settings();
      //case 7-> System.out.println("Call Divert");
      //case 8-> System.out.println("Games");
      //case 9-> System.out.println("Calculator");
      //case 10-> System.out.println("Reminders");
      //case 11-> Clock();
      //case 12-> System.out.println("Profiles");
      //case 13-> System.out.println("SIM Services");
    }
  }


}
