package week1.fireDrillTwo;

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

  private static void MainMenu() {
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

    switch (input) {
      case 1 -> {
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
        System.out.println(phonePrompt);
        int phoneBook = scanner.nextInt();
        switch (phoneBook) {
          case 1 -> System.out.println("Search");
          case 2 -> System.out.println("Service Nos.");
          case 3 -> System.out.println("Add name");
          case 4 -> System.out.println("Erase");
          case 5 -> System.out.println("Edit");
          case 6 -> System.out.println("Assign Tone");
          case 7 -> System.out.println("Send b'card");
          case 8 -> {
            String optionsPrompt = """
                    Press 1 -> Type of view
                    Press 2 -> Memory status
                    Press 0 -> Go back
                    """;
            System.out.println(optionsPrompt);
            int optionsInput = scanner.nextInt();
            switch (optionsInput) {
              case 1 -> System.out.println("Type of view");
              case 2 -> System.out.println("Memory status");
            }
          }
          case 9 -> System.out.println("Speed dials");
          case 10 -> System.out.println("Voice tags");
        }
      }
      case 2 -> {
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
        System.out.println(messagesPrompt);
        int messages = scanner.nextInt();
        switch (messages) {
          case 1 -> System.out.println("Write Messages");
          case 2 -> System.out.println("Inbox");
          case 3 -> System.out.println("Outbox");
          case 4 -> System.out.println("Picture Messages");
          case 5 -> System.out.println("Templates");
          case 6 -> System.out.println("Smileys");
          case 7 -> {
            String setingsPrompt = """
                      Press 1 -> Message centre number
                      Press 2 -> Message sent as
                      Press 3 -> Message validity
                    """;
            System.out.println(setingsPrompt);
            int settings = scanner.nextInt();
            switch (settings) {
              case 1 -> System.out.println("Message centre number");
              case 2 -> System.out.println("Message sent as");
              case 3 -> System.out.println("Message validity");
            }
          }
        }
      }

      case 3 -> System.out.println("Chat");
      case 4 -> {
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
        System.out.println(callRegisterPrompt);
        int phoneBook = scanner.nextInt();
        switch (phoneBook) {
          case 1 -> System.out.println("Missed calls");
          case 2 -> System.out.println("Received calls");
          case 3 -> System.out.println("Dialed numbers ");
          case 4 -> System.out.println("Erase recent call list");
          case 5 -> {
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
              case 1 -> System.out.println("Last call duration");
              case 2 -> System.out.println("All calls' duration");
              case 3 -> System.out.println("Receive calls' duration");
              case 4 -> System.out.println("Dialled calls' duration");
              case 5 -> System.out.println("Clear timers");
            }
          }
          case 6 -> {
            String costPrompt = """
                    Press 1-> Last call cost
                    Press 2 -> All calls' cost
                    Press 3 -> Clear counters
                    """;
            System.out.println(costPrompt);
            int costInput = scanner.nextInt();
            switch (costInput) {
              case 1 -> System.out.println("Last call cost");
              case 2 -> System.out.println("All calls' cost");
              case 3 -> System.out.println("Clear counters");
            }
          }
          case 7 -> {
            String callSettings = """
                      Press 1 -> Call cost limit
                      Press 2 -> Show costs in
                    """;
            System.out.println(callSettings);
            int optionsInput = scanner.nextInt();
            switch (optionsInput) {
              case 1 -> System.out.println("Type of view");
              case 2 -> System.out.println("Memory status");
            }
          }
          case 8 -> System.out.println("Prepaid credit");
        }
      }


      case 5 -> {

      String tonePrompt = """
              Press 1 -> Ringing tone
              Press 2 -> Ringing volume
              Press 3 -> Incoming call alert
              Press 4 -> Composer
              Press 5 -> Message alert tone
              Press 6 -> Keypad tones
              Press 7 -> Warning and game tones
              Press 8 -> Vibrating alert
              Press 9 -> Screen saver
              Press 0 -> Go back
              """;
        System.out.println(tonePrompt);
      int phoneBook = scanner.nextInt();
      switch (phoneBook) {
        case 1 -> System.out.println("Ringing tone");
        case 2 -> System.out.println("Ringing volume");
        case 3 -> System.out.println("Incoming call alert");
        case 4 -> System.out.println("Composer");
        case 5 -> System.out.println("Message alert tone");
        case 6 -> System.out.println("Keypad tones");
        case 7 -> System.out.println("Warning and game tones");
        case 8 -> System.out.println("Vibrating alert");
        case 9 -> System.out.println("Screen saver");
      }
    }

      case 6-> {
        String settingsPrompt = """
                Press 1 -> Call settings
                Press 2 -> Phone settings
                Press 3 -> Security settings
                Press 4 -> Restore factory settings
                Press 0 -> Go back
                """;
        System.out.println(settingsPrompt);
        int messages = scanner.nextInt();
        switch (messages) {
          case 1 -> {
            String callPrompt = """
                      Press 1 -> Automatic redial
                      Press 2 -> Speed dialling
                      Press 3 -> Call waiting options
                      Press 4 -> Own number sending
                      Press 5 -> Phone line in use
                      Press 6 -> Automatic answer
                      Press 0 -> Go back
                    """;
            System.out.println(callPrompt);
            int callSettings = scanner.nextInt();
            switch (callSettings) {
              case 1 -> System.out.println("Automatic redial");
              case 2 -> System.out.println("Speed dialling");
              case 3 -> System.out.println("Call waiting options");
              case 4 -> System.out.println("Own number sending");
              case 5 -> System.out.println("Phone line in use");
              case 6 -> System.out.println("Automatic answer");
            }
          }

          case 2 -> {
            String callPrompt = """
                      Press 1 -> Language
                      Press 2 -> Cell info display
                      Press 3 -> Welcome note
                      Press 4 -> Network selection
                      Press 5 -> Lights
                      Press 6 -> Confirm SIM service actions
                      Press 0 -> Go back
                    """;
            System.out.println(callPrompt);
            int phoneSettings = scanner.nextInt();
            switch (phoneSettings) {
              case 1 -> System.out.println("Language");
              case 2 -> System.out.println("Cell info display");
              case 3 -> System.out.println("Welcome note");
              case 4 -> System.out.println("Network Selection");
              case 5 -> System.out.println("Lights");
              case 6 -> System.out.println("Confirm SIM service actions");
            }
          }

          case 3 -> {
            String callPrompt = """
                      Press 1 -> PIN code request
                      Press 2 -> Call barring service
                      Press 3 -> Fixed dialling
                      Press 4 -> Closed user group
                      Press 5 -> Phone security
                      Press 6 -> Change access codes
                      Press 0 -> Go back
                    """;
            System.out.println(callPrompt);
            int securitySettings = scanner.nextInt();
            switch (securitySettings) {
              case 1 -> System.out.println("PIN code request");
              case 2 -> System.out.println("Call barring service");
              case 3 -> System.out.println("Fixed dialling");
              case 4 -> System.out.println("Closed user group");
              case 5 -> System.out.println("Phone security");
              case 6 -> System.out.println("Change access codes");
            }
          }
        }
      }
      case 7-> System.out.println("Call Divert");
      case 8-> System.out.println("Games");
      case 9-> System.out.println("Calculator");
      case 10-> System.out.println("Reminders");
      case 11-> {
        String clockPrompt = """
                      Press 1 -> Alarm clock
                      Press 2 -> Clock settings
                      Press 3 -> Date setting
                      Press 4 -> Stopwatch
                      Press 5 -> Countdown timer
                      Press 6 -> Auto update of date and time
                      Press 0 -> Go back
                    """;
        System.out.println(clockPrompt);
        int clockSettings = scanner.nextInt();
        switch (clockSettings) {
          case 1 -> System.out.println("Alarm clock");
          case 2 -> System.out.println("CClock settings");
          case 3 -> System.out.println("Date setting");
          case 4 -> System.out.println("Stopwatch");
          case 5 -> System.out.println("Countdown timer");
          case 6 -> System.out.println("Auto update of date and time");
        }
      }
      case 12-> System.out.println("Profiles");
      case 13-> System.out.println("SIM Services");
    }
  }


}
