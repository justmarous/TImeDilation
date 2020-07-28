import java.math.BigDecimal;

public class AstronomicalObject {

    private String name;
    private double mass;
    private double radius; //in meters
    private double bigG=6.6742* Math.pow(10,-11);
    private double c = 299792458;

    public AstronomicalObject()
    {
        this("Sun",(1.9891*Math.pow(10,30)),(6.96342*Math.pow(10,8)));
    }

    public AstronomicalObject(double mass) {
        this(mass,0);
    }

    public String getName() {
        return name;
    }

    public AstronomicalObject(double mass, double radius) {
        this("Custom astronomical object",mass,radius);
    }
//one
    public AstronomicalObject(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public double schwartzschildFactor (double distanceFromObject)
    {
        distanceFromObject*=1000;
        return 1/Math.sqrt(1 - (  (2*bigG*this.mass) / ( (this.radius+distanceFromObject) *c*c)  ) );
    }

    public void eventHorizon ()
    {
        System.out.println("Event horizon is at "+((2*bigG*this.mass)/(c*c))+" m from the body.");
    }
}
