import java.util.Scanner;

public class ATM_MACHINE {
        static Scanner cin = new Scanner(System.in);

        static String acc_id;
        static String pass;
        static int Account;
        static int sec_pin;
        static double present_amt = 250000f;
        static int sent = 0;
        static String sent_History = "";

        public static void NEW_CONSUMER(){

            System.out.println("\nEnter your User_ID  :");
            acc_id = cin.next();
            System.out.println("ENTER YOUR SECURITY CODE :");
            pass = cin.next();
            System.out.println("ENTER YOUR ACCOUNT NUMBER  :");
            Account = cin.nextInt();
            System.out.println("ENTER YOUR ATM CONFIDENTIAL PIN  :");
            sec_pin=cin.nextInt();
            System.out.println("\n REGISTERED SUCCESFULLY");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("YOU CAN NOW LOGIN !!");

        }

        public static boolean REGISTEREDIN(){
            boolean is_Loggedin = false;
            while(!is_Loggedin)
            {
                System.out.println("\n ENTER YOUR ACCOUNT NUMBER :");
                int Acc_num = cin.nextInt();
                if(Acc_num == Account)
                {
                    System.out.println("ENTER YOUR ATM CONFIDENTIAL PIN ");
                    int pin_enter = cin.nextInt();
                    while(!is_Loggedin)
                    {
                        if(pin_enter == sec_pin)
                        {
                            System.out.println("\n LOGIN SUCCESSFUL");
                            is_Loggedin = true;
                        }
                        else
                        {
                            System.out.println("\nENTER CORRECT PIN");
                            break;
                        }

                    }
                }
                else
                {
                    System.out.println("\nENTER VALID ACCOUNT NUMBER");
                }
            }
            System.out.println("------------------------------------------------------------------------");
            return is_Loggedin;

        }

        public static void SEE_BALANCE(){
            System.out.println("\nYOUR CURRENT BALANCE IS  : "+present_amt);
        }

        public static void AMT_ADD(){
            System.out.println("\nAMOUNT TO BE DEPOSITED ");
            float ADD_CASH = cin.nextFloat();
            present_amt = present_amt+ADD_CASH;
            System.out.println("\nAMOUNT SUCCESSFULLY DEPOSITED");
            System.out.println("After depositing "+ADD_CASH+", balance is "+present_amt);
            sent+=1;
            String s = "Rs. "+ADD_CASH+" deposited to account\n";
            sent_History = sent_History.concat(s);

            System.out.println("-----------------------------------------------------------------");
        }

        public static void AMT_TAKEN(){
            System.out.println("\nAMOUNT TO  BE WITHDRAW");
            float TAKEN_A = cin.nextFloat();
            if(TAKEN_A<=present_amt)
            {
                System.out.println("\nYOU HAVE WITHDRAWN AMOUNT : "+TAKEN_A);
                present_amt = present_amt-TAKEN_A;
                System.out.println("YOUR REMAINING BALANCE "+present_amt);
                sent+=1;
                String s = "Rs. "+TAKEN_A+" AMOUNT WITHDRAWN\n";
                sent_History = sent_History.concat(s);
            }
            else
            {
                System.out.println("\nINSUFFICIENT BALANCE");
                System.out.println("YOUR CURRENT BALANCE "+present_amt);
            }

            System.out.println("------------------------------------------------------------------------");
        }

        public static void SEND(){
            System.out.println("\nENTER ACCOUNT NUMBER FOR TRANSFER : ");
            String ACCOUNT = cin.next();
            System.out.println("ENTER AMOUNT TO BE TRANSFERRED ");
            float SEND_A = cin.nextInt();

            if(SEND_A<=present_amt)
            {
                System.out.println("\nTRANSACTION SUCCESSFUL");
                present_amt = present_amt-SEND_A;
                System.out.println("REMAINING BALANCE "+present_amt);
                sent+=1;
                String s = "Rs. "+SEND_A+" AMOUNT TRANSFERRED\n";
                sent_History = sent_History.concat(s);
            }
            else
            {
                System.out.println("\nINSUFFICIENT AMOUNT FOR TRANSFER");
                System.out.println("BALANCE : "+present_amt);
            }
            System.out.println("----------------------------------------------------------------------------");
        }


        public static void MINI_STATEMENT(){
            if(sent==0){
                System.out.println("0 TRANSACTION");
            }
            else
            {
                System.out.println(sent_History);
            }
            System.out.println("---------------------------------------------------------------------------");
        }

        public static void main(String args[]){

            System.out.println("\nWELCOME !!");
            System.out.println("                                                                   ");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("\nSELECT AN OPTION");
            System.out.println("1.REGISTER\n2.EXIT");
            System.out.println("\nENTER YOUR OPTIION:");

            int CHOICE = cin.nextInt();

            if(CHOICE == 1)
            {
                NEW_CONSUMER();
                while(CHOICE == 1){
                    System.out.println("\nSELECT ONE OPTION");
                    System.out.println("1.LOGIN\n2.EXIT");
                    System.out.println("\nYOUR OPTION :");
                    int OPTION=cin.nextInt();
                    if (OPTION==1)
                    {
                        if(REGISTEREDIN())
                        {
                            boolean is_STOP = false;
                            while(!is_STOP)
                            {
                                System.out.println("\nSELSECT AN OPTION: ");
                                System.out.println("1.TRANSACTION HISTORY\n2.WITHDRAW\n3.DEPOSIT\n4.TRANSFER\n5.CHECK BALANCE\n6.EXIT");
                                System.out.println("\nENTER YOUR OPTION:");
                                int c=cin.nextInt();
                                switch(c){
                                    case 1 : MINI_STATEMENT();
                                        break;
                                    case 2 : AMT_TAKEN();
                                        break;
                                    case 3 : AMT_ADD();
                                        break;
                                    case 4 : SEND();
                                        break;
                                    case 5 :SEE_BALANCE();
                                        break;
                                    case 6 : is_STOP=true;
                                        System.out.println("\nCOLLECT YOUR CARD !!!!");
                                        break;
                                    default: System.out.println("ENTER INVALID OPTION !!!");
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("\nCOLLECT YOUR CARD !!!1!");
                        System.exit(0);
                    }
                    break;
                }

            }
            else
            {
                System.out.println("\nCOLLECT YOUR CARD !!!!");
                System.exit(0);
            }
        }
    }

