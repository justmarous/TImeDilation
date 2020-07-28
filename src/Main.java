import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("\nWhat do you want to calculate? - put proper number\n");


        boolean continuing = true;
        int choice=0;

        while(continuing) {

            printInstruction();
            choice = scanner.nextInt();
            switch (choice)
                {
                    case 0:
                        break;
                    case 1:
                        System.out.println("*** Speed dilation program initialized ***");
                        lorenzFactor();
                        clickEnter();
                        break;
                    case 2:
                        System.out.println("&&& Gravitational dilation program initialized &&&");
                        schwartchildFactor();
                        clickEnter();
                        break;
                    case 3:
                        System.out.println("FINISHING...");
                        continuing=false;
                        break;
                    default:
                        System.out.println("Put proper choice!");
                        clickEnter();
                        break;
                }
            }
        }



        public static void schwartchildFactor()
        {
            AstronomicalObject[] stellarList = new AstronomicalObject [5];

            AstronomicalObject earth = new AstronomicalObject("Earth",5.97219*Math.pow(10,24),6.371*Math.pow(10,6));
            AstronomicalObject sun = new AstronomicalObject("Sun",1.9891*Math.pow(10,30),6.96342*Math.pow(10,8));
            AstronomicalObject jupiter = new AstronomicalObject("Jupiter",1.89919*Math.pow(10,27),6.9911*Math.pow(10,7));
            AstronomicalObject gargantua = new AstronomicalObject("Gargantua",1.9891*Math.pow(10,38),1.49_597_871 *Math.pow(10,11));

            stellarList[0]=earth;
            stellarList[1]=sun;
            stellarList[2]=jupiter;
            stellarList[3]=gargantua;


            double schwartzschild=1;
            double schwarzchwildEarth = earth.schwartzschildFactor(0);

            System.out.println("What astronomical body do you want to choose?\n\t 0: Earth\n\t 1: Sun \n\t 2: Jupiter \n\t 3: Gargantua \n\t 4: CUSTOM");

            int choice = scanner.nextInt();
            double distance;

            if(choice==4)
            {
                System.out.println("What would be the mass of your custom being? (10 to power of ... [kg] )");

                double mass =(double) scanner.nextInt();
                mass = Math.pow(10,mass);

                System.out.println("What would be the radius of the being? [km]");
                double radius = scanner.nextDouble();
                radius *=1000;

                AstronomicalObject customObject = new AstronomicalObject("Custom object",mass,radius);
                stellarList[4]=customObject;
                System.out.println("Okay, "+customObject.getName()+" has been created.");
            }

            else

                {
                    System.out.println("You have chosen "+stellarList[choice].getName()+".");

                    stellarList[choice].eventHorizon();

            }
            distance=0;
            while(distance!=997) { //LF "per around 0.000016 seconds" - 145_825_211 km: one second there is equal to 23872.643148952524 on Earth
                System.out.println("How far are you from this body? (km)");
                distance = scanner.nextDouble();
                schwartzschild = stellarList[choice].schwartzschildFactor(distance);
        ///

                System.out.println("The time dilation will be of value equal to: " + schwartzschild);

                System.out.println("During one second in there it will pass " + schwartzschild + " in cosmic space, and " + (1 + schwartzschild - schwarzchwildEarth) + " on the Earth.\n\tThat is, time passes " + (schwartzschild / schwarzchwildEarth) + " times as on Earth.");
                System.out.println("It means total difference of 1 second per around " + timeFormat(((1 / (schwartzschild - 1)))) + ", comparing to interstellar space.");
                System.out.println("\nTo be specific, one second there is equal to " + schwartzschild / schwarzchwildEarth + " on Earth.");

            }

        }


    public static void lorenzFactor ()
    {
        System.out.println("How fast do you move in km/h?");

        double relativeVelocity = scanner.nextDouble() / 3.6;
        double c = 299792458;
        int yearInSeconds = 15768000*2;

        double lorenzFactor =  1/(Math.sqrt(1-(  (Math.pow(relativeVelocity,2))/(c*c)    )));


        System.out.println("So, 1 second of the time passed for you is equal to "+lorenzFactor+" seconds for the observer.");
        System.out.println("That means, the time difference in a year would be equal to "+(lorenzFactor-1)*yearInSeconds+ " seconds.");
    }

    public static void printInstruction()
    {
        System.out.println("\tClick 0 for instruction");
        System.out.println("\tClick 1 for speed dilation");
        System.out.println("\tClick 2 for gravitational dilation");
        System.out.println("\tClick 3 to finish");
    }
//two

    public static void clickEnter()
    {
        System.out.println("\nClick enter key to proceed...");
        String readString = scanner.nextLine();
        scanner.nextLine();
        while(readString!=null) {
            if (readString.isEmpty()) {
                break;
            }
            if (scanner.hasNextLine()) {
                readString = scanner.nextLine();
            } else {
                readString = null;
            }
        }
    }

    public static String timeFormat(double timeValue)
    {
        if(timeValue<60)
            return timeValue+" seconds";

        timeValue /= 60;

        if(timeValue<60)
            return timeValue+" minutes";

        timeValue /=24;

        if(timeValue<365)
            return timeValue+" days";

        timeValue /= 365;

            return timeValue+" years";

    }


}

